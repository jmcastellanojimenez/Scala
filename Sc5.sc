//PROGRAMACION ORIENTADA A OBJETOS
//CLASES
//Las Clases son el núcleo para la creación aplicaciones orientadas a objetos (OOP). Son una
//combinación de estructuras de datos y funciones (métodos).
//Se pueden instanciar muchas veces, cada instancia inicializada con sus propios datos.
//Pueden heredar propiedades de otras clases para crear una jerarquía de subclases o
//superclases. Pueden adoptar polimorfismo.

class User {
  val name: String = "Pedro"
  def greet: String = s"Hola soy $name"
    override def toString = s"User($name)"
}
val u = new User
println( u.greet )

//CLASES CON PARAMETROS DE ENTRADA
//Se pueden definir las clases con parámetros de entrada y valores por defecto
class Car(val marca: String, var reservado: Boolean = true,
          val ano: Int = 2015) {
  override def toString = s"$ano $marca, reservado = $reservado"
}
val a = new Car("Acura")
val l = new Car("Lexus", ano = 2010)
val p = new Car(reservado = false, marca = "Porsche")

//CLASES CON PARAMETROS DE TIPO
//Podemos crear nuestra propia colección con el tipo que queramos.
class Singular[A](elemento: A) extends Traversable[A] {
  def foreach[B](f: A => B) = f(elemento)
}
val p = new Singular("Planes")
p.foreach(println)
val name: String = p.head
val p1 = new Singular(6)

//CLASES ABSTRACTAS
//Una clase abstracta es una clase diseñada para ser extendida por
// otras clases, pero no para instanciarse.
abstract class Car {
  val ano: Int
  val automatico: Boolean = true
  def color: String
}
// CASCA "clase abstracta no se puede instanciar" --> new Car()
class RedMini(val ano: Int) extends Car {
  def color = "Red"
}
val m: Car = new RedMini(2005)


//CASE CLASES
//Una Case Class es una clase instanciable que incluye varios métodos que se generan
//automáticamente. Son inmutables por defecto.
//Usadas para cargar datos. Cada línea del fichero de datos en una clase.
//CLASES CASE VER METODOS en la doc
case class Character(nombre: String, trabajo: Boolean)
val h = Character("Antonio", true)
val r = h.copy(nombre = "Pedro")
h == r
h match {
  case Character(x, true) => s"$x tiene trabajo"
  case Character(x, false) => s"$x no tiene trabajo"
}


//CLASES TRAIT
// Traits son Clases abstractas que se usan para añadir métodos y campos a
// clases padres desconocidas. Es una manera de encapsular propiedades/funciones
// que se pueden reusar en distintas clases.
trait HtmlUtils {
  def removeMarkup(input: String) = {
    input.replaceAll("""</?\w[^>]*>""","").replaceAll("<.*>","")
  }
}

class Page(val s: String) extends HtmlUtils {
  def asPlainText = removeMarkup(s)
}

new Page("<html><body><h1>Introduction</h1></body></html>").asPlainText


//OBJETOS
//Un objeto (Object) es un tipo de clase que no puede tener más de una
// instancia. Se le conoce en OOP como un singleton. Se accede directamente
// al objeto por su nombre y métodos. Cuando tienen el método
// def main(args: Array[String]) se convierten en aplicaciones Scala.

object Summer {
  def main(args: Array[String]) {
    for (arg <- args)
      println(arg)
  }
}
