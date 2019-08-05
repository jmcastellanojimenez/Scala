import com.sun.tools.javac.jvm.Items

import scala.collection.immutable.Range
import scala.math.Numeric.FloatAsIfIntegral

//1. Escribir una función que calcule el área del círculo conociendo su radio.
//Manual o con las librerias matematicas
def radio (r: Double): Double = {
  r * r * 3.1416
}
def radio2(r2: Double) = math.pow(r2,2) * math.Pi
radio(8)
radio2(8)

//2. Que el radio sea un String. Si la función se llama con un String vacio?
//Con IF o con MATCH
def radio3 (r3: String): Double = {
  if (r3.isEmpty) { println("Vacio"); 0 }
  else
    r3.toDouble * r3.toDouble * 3.1416
}
radio3("")

def radio4(r4: String): Double = {
  r4.isEmpty match {
    case true => 0
    case false => math.pow(r4.toDouble,2) * math.Pi
  }
}
radio4("")

//3. Función recursiva que imprima los valores del 5 al 50 de 5 en 5 sin bucles.
@annotation.tailrec
def recursiva(n: Int, m: Int): Unit = {
  if (n <= m) {
    println(n)
    recursiva(n + 5, m)
  }
}
recursiva(0, 50)

//4. Función con parámetro en ms devuelva String días, horas, minutos y segundos.
def milisegundos (m: Float)= {
  val d = m / 86400000
  val h = m / 3600000
  val mn = m / 60000
  val s = m / 1000
  f"dias $d%.0f, horas $h%.0f, minutos $mn%.0f, segundos $s%.0f"
}
milisegundos(123456789000F)

//5. Función que calcule el primer valor elevado al Segundo.
def power1(x: Int, n: Int): Long = {
  if (n >= 1) x * power1(x, n-1)
  else 1
}
print(power1(2,2))

//6. Función que calcule la diferencia entre un par de puntos
//(x,y) y devuelva el resultado como un punto. Usar tuplas.
def diferencia(items: (Int, Int)): Int = {
  items._2 - items._1
}
diferencia(1,8)

//7. Función que coja una tupla de 2 elementos y la devuelva con el valor Int
//en la primera posición si se incluye. Parametrización de tipos e isInstanceOf.
def intFirst[A,B](t: (A,B)): (Any,Any) = {
  def isInt(x: Any) = x.isInstanceOf[Int]
  (isInt(t._1), isInt(t._2)) match {
    case (false, true) => (t._2, t._1)
    case _ => t
  }
}
intFirst( ('a', 2) )
intFirst( (1, false) )
intFirst( (1, 4) )

//8. Función que multiplique dos enteros y que use dos placeholders.
// Le pasamos los dos numeros y la funcion hecha que es multiplicarlos.
def combination(x: Int, y: Int, f: (Int,Int) => Int) = f(x,y)
combination(23, 12, _ * _)