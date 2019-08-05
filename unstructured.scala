//Place the CSV data file "Transacciones" in the same directory

import java.io._
import scala.io.Source

object unstructured {
  def main(args: Array[String]): Unit = {
    case class Sale(date: String, product: String, price: Int, paymentType: String, country: String)

    class ReadCSVFile(val fileName: String) {
      def readFile(): Seq[Sale] = {
        for {
          line <- Source.fromFile(fileName).getLines().drop(1).toVector
          values = line.split(",").map(_.trim)
        } yield Sale(values(0), values(1), values(2).toInt, values(3), values(4))
      }
    }
    class SalesStatistics(val salesFile: String) {

      val sales = new ReadCSVFile(salesFile).readFile()

      // Numero total de ventas
      def getVentasTotales(): Int = sales.size

      // Devuelve la venta promedio de una Seq de ventas
      def promedio(ventasTipo: Seq[Sale]): Double =
        ventasTipo.map(_.price).sum / ventasTipo.size

      // Creamos un Map donde la clave es el tipo de pago y el valor la venta media para cada tipo de pago
      def ventaMediaPorTipoPago(): Map[String, Double] = {
        //println(sales.groupBy(_.paymentType))
        sales.groupBy(_.paymentType).mapValues(promedio(_))
      }

      // Creamos un Map donde la clave es el tipo de pago y el valor total de la venta media para cada tipo de pago
      def ventaTotalPorTipoPago():  Map[String, Double] = {
        //println(sales.groupBy(_.paymentType))
        sales.groupBy(_.paymentType).mapValues(_.map(_.price).sum)
      }

      // Devuelve de una venta el dia-mes
      def getDiaMes(sale: Sale): String = {
        val parts = sale.date.split(" ")(0).split("-")
        parts(2) + "/" + parts(1)
      }

      // Creamos un Map con clave es el dia en formato dia-mes y el valor el numero de ventas realizadas en ese dia
      def ventasPorDia(): Map[String, Int] = {
        //println(sales.groupBy(getDiaMes(_)))
        sales.groupBy(getDiaMes(_)).mapValues(_.size) // Se puede usar .lenght
      }

      // Creamos un Map con clave es el dia en formato dia-mes y el valor medio de ventas realizadas en ese dia
      def ventaMediaPorDia(): Map[String, Double] = {
        sales.groupBy(getDiaMes(_)).mapValues(promedio(_))
      }

      // Total de ventas y valor de las ventas para un pais
      def ventasTotalesPais(segmento: String, pais: String): (Int, Int) = {
        //val filtered = sales.filter(_.country == pais)
        //(filtered.size, filtered.map(_.price).sum)
        segmento match {
          case "in" => val filtered = sales.filter(_.country == pais);(filtered.size, filtered.map(_.price).sum)
          case "out" => val filtered = sales.filter(_.country != pais);(filtered.size, filtered.map(_.price).sum)
          case other => println("Error");(0, 0)
        }
      }

      // Creamos un Map con clave es el dia en formato dia-mes y el valor medio de ventas realizadas en ese dia para un pais
      def ventaMediaDiariaPais(segmento: String, pais: String): Map[String, Double] = {
        segmento match {
          case "in" => val filtered = sales.filter(_.country == pais);filtered.groupBy(getDiaMes(_)).mapValues(promedio(_))
          case "out" => val filtered = sales.filter(_.country != pais);filtered.groupBy(getDiaMes(_)).mapValues(promedio(_))
          case other => println("Error");Map(""->0)
        }
      }
      // Por Tipo de pago y pais
      def ventaTipoPais(segmento: String, pais: String): Map[String, Double] = {
         segmento match {
          case "in" => val filtered = sales.filter(_.country == pais);filtered.groupBy(_.paymentType).mapValues(_.map(_.price).sum)
          case "out" => val filtered = sales.filter(_.country != pais);filtered.groupBy(_.paymentType).mapValues(_.map(_.price).sum)
          case other => println("Error");Map()
        }
      }
    }
    val ventas = new SalesStatistics("Transacciones.txt")

    println("Numero Total de Ventas: " + ventas.getVentasTotales)
    println("Venta numero 1: " + ventas.sales(0))
    println("Venta numero 100: " + ventas.sales(100))

    println("Venta Media por tipo de pago: " + ventas.ventaMediaPorTipoPago)
    println("Venta Total por tipo de pago: " + ventas.ventaTotalPorTipoPago)

    println("Numero de ventas totales por dia: " + ventas.ventasPorDia)
    println("Venta Media por Dia: " + ventas.ventaMediaPorDia)
    val a = ventas.ventaMediaPorDia
    println("Venta Media del dia 9/11: " + a("9/11"))

    println("Ventas en USA: " + ventas.ventasTotalesPais("in","USA"))
    println("Ventas fuera USA: " + ventas.ventasTotalesPais("out","USA"))

    println("Venta Media por dia Francia: " + ventas.ventaMediaDiariaPais("in","Francia"))
    println("Dia Maxima Venta fuera Rusia: " + ventas.ventaMediaDiariaPais("out","Rusia").valuesIterator.max)
    println("Dia Maxima Venta fuera Rusia: " + ventas.ventaMediaDiariaPais("out","Rusia").maxBy(_._2))

    println("Ventas por tipo de pago en Italia: " + ventas.ventaTipoPais("in","Italia"))
    println("Ventas de Visa en Italia: " + ventas.ventaTipoPais("in","Italia")("Visa"))

  }
}
