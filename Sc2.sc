//Funciones

// sin parámetros/argumentos
def hola = "hola"

// con un tipo de retorno
def hola: String = "hola"

// forma general
def safeTrim(s: String): String = {
  if (s == null) return null
  s.trim()
}

// procedimiento. función que no retorna valor. "Unit" sólo si contiene +1 línea.
def valor(d: Double) = println(f"valor $d%.2f")
def valor(d: Double): Unit = println(f"Valor $d%.2f")

// sin variables pasarle un cálculo en el bloque de expresión de la función
def formatEuro(total: Double) = f"€$total%.2f"
formatEuro(3.4645)
formatEuro { val rate = 1.32; 0.235 + 0.7123 + rate * 5.32 }

// funciones recursivas
def power(x: Int, n: Int): Long = {
  if (n >= 1) x * power(x, n-1)
  else 1
}

power(8, 2)

// con tailrec prevenimos “Stack overflow”. Las llamadas comparten stack
//@annotation.tailrec
def power1(x: Int, n: Int): Long = {
  if (n >= 1) x * power1(x, n-1)
  else 1
}

// funciones anidadas. Teniendo distinto scope (arguments) pueden llamarse igual
def max(a: Int, b: Int, c: Int) = {
  def max(x: Int, y: Int) = if (x > y) x else y
  max(a, max(b, c))
}

max(42, 181, 19)

// funciones con llamadas nominales.
// cambiar el orden de los argumentos, pero especificandolo
def greet(prefix: String, name: String) = s"$prefix $name"
val greeting1 = greet("Sr", “Perez")
  val greeting2 = greet(name = "Perez", prefix = "Sr")

  // function overloading. Funciones con argumentos por defecto
  // en el ejemplo asignamos "blanco" a "prefix" en la llamada
  def greet(name: String, prefix: String = "") = s"$prefix$name"
val greeting2 = greet("Hola")

// funciones con parametros VARARG
// el numero de argumentos es variable pero siempre del mismo tipo
def suma(items: Int*): Int =
  var total = 0
  for (i <- items) total += i
  total


suma(10, 20, 30)
suma()

// funciones con grupos de parametros
// sirve de manera visual para aclararse
def max(x: Int)(y: Int): Int = if (x > y) x else y
val larger = max(20)(39)

// funciones con parametrizacion de tipos. Flexibilidad y reusabilidad
// lo que sirve para definir los tipos a usar en la entrada o en el retorno
def identity[A](a: A): A = a
val s: String = identity[String]("Hello")
val d: Double = identity[Double](2.717)

// funciones definidas dentro de una clase. Toda variable/tipo es una clase.
// Metodos
val s = "vacation.jpg"
val isJPEG = s.endsWith(".jpg")
val d = 65.642
d.round
d.floor

// funciones CLOSURE
// cuyo valor de retorno depende de los valores
//de una o más variables declaradas fuera de la función
// Un objeto con una funcion MAIN ya es un ejecutable
object Intellipaat
  def main(args: Array[String])
    println("First operation value: " +sum(1))
    println("Second operation value: " +sum(2))
  var value = 20
  val sum = (i:Int) => i + value

//Funciones FIRST-CLASS o high-order. Ejemplo map() y reduce()

// funcion TIPO
def double(x: Int): Int = x * 2
double(5)

val myDouble: (Int) => Int = double
myDouble(5)

val myDoubleCopy = myDouble
myDoubleCopy(5)

// funcion con operador "_"
// La misma funcion "double" en vez de poniendo "Int" poniendo "_"
val myDouble: = double _
myDouble(5)

//Funcion high-order. Recibe una funcion como agumento
def safeStringOp(s: String, f: String => String)
  if (s != null) f(s) else s
def reverser(s: String) = s.reverse
safeStringOp(null, reverser)
safeStringOp("Ready", reverser)

// funcion LITERAL
// Es una expresión parametrizada, lo que las funciones lambda a Python
val doubler = (x: Int) => x * 2
val doubled = doubler(22)

// funcion LITERAL con placeholder
// forma corta funciones literales, parámetros por "_"
// Usar cuando el tipo explícito de la función se especifica fuera
// del literal y cuando los parámetros no se usan más de una vez.
val doubler: Int => Int = _ * 2

def safeStringOp(s: String, f: String => String)
  if (s != null) f(s) else s

safeStringOp(null, _.reverse)
safeStringOp("Ready", _.reverse)
