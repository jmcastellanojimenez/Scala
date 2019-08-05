//COLECCIONES MUTABLES: SECUENCIAS Y ARRAYS

//Las colecciones List, Set, y Map son inmutables, pero pueden convertirse a
// mutables. Cuando creamos una colección mutable debemos incluir
// todo el nombre del paquete.
collection.immutable.List
collection.immutable.Set
collection.immutable.Map
collection.mutable.Buffer
collection.mutable.Set
collection.mutable.Map
val nums = collection.mutable.Buffer[Int]()
for (i <- 1 to 10) nums += i
println(nums)

//ARRAYS
//Un Array es una colección indexada de tamaño fijo y mutable.
//No es oficialmente una colección, es un wrapper del Array de Java.
//Los Array no sobrecargan el método toString()
val colors = ("Arrayrojo", "verde", "azul")
//colors(0) = "dorado"
colors
println("muy dorado: " + colors)

//SEQ Y SECUENCIAS
//Seq es la raíz de todas las secuencias. El tipo Array se puede considerer como una secuencia
//indexada. Seq no se puede instanciar, pero se puede invocar para crear una Lista.
val inks = Seq('C','M','Y','K')


//OPTIONS
//No es en si una colección, sino un contenedor. Tiene dos subtipos: Some, un tipo de colección
//con un elemento y None, una colección vacía.
//Algunos desarrolladores ven en Option un reemplazamiento seguro de los valores null,
//reduciendo así la posibilidad de que se generen NullPointerException.
case class Customer(
  first: String = "",
  middle: Option[String] = None,
  last: String = "")

Customer("Martin", last= "Odersky")

//Se usa isDefined y isEmpty para comprobar si una Opcion es Some o None:
var x: String = "Indeed"
var a = Option(x)
x = null
var b = Option(x)
println(s"a is defined? ${a.isDefined}")
println(s"b is not defined? ${b.isEmpty}")

