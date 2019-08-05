//Modo consola creando una Worksheet. Va definiendo
//variables que se pueden ir usando
1+1
res0+2
1 to 100

//Variables y valores. Mutable e inmutable.
val a=1
val msg="Hola Mundo!"
var b=2

//Las condiciones booleanas hacerlas explicitamente
val zero: Int =0
val isValid = zero < 0

//Conversion de tipos. Todos los tipos son clases
zero.asInstanceOf[Float]
zero.toDouble

//Ver el tipo
zero.getClass()

//String. Inmutable
//Java + interpoladores s/f/raw
val firma = "Con saludos, \nTu amigo"
"No"*16
val aprox=355/113f
println(s"El valor de pi 355/113 es $aprox")
val item="naranja"
s"Te gustan las {$item}s"
s"gato, perro, ${"caballo, "*3}conejo"
val altura = 1.9d
val nombre = "Antonio"
f"$nombre%s tiene una altura de $altura%2.2f metros"
//Como las """ no interpreta especiales
s"a\nb"
raw"a\nb"

//Metodos de String
val metodos = "Almeja"
println(metodos.length)
println(metodos.charAt(2))
println(metodos.startsWith("a"))
println(metodos.endsWith("a"))
println(metodos.indexOf("m"))
println(metodos.substring(1, 3))
val newmetodos = metodos.concat(" con arroz")
println(newmetodos)
if(metodos.contains("lm")) println("True")
println(metodos.replace("lm","sr"))
println(metodos.toLowerCase())
println(metodos.toUpperCase())
println(metodos.trim)
println(metodos.isEmpty)
println(metodos.codePointAt(2))
println(metodos.toCharArray)

//Tuplas. Agrupacion lógica de valores de cualquier tipo
//No son iterables, sólo acceder a los elem. por indice
val pepe =("hi", "pepe", true)
val pepe2 = "hi" -> "pepe" -> true
pepe._1
val reverse = pepe._2 -> pepe._3

//Expresiones
//Como en las funciones, la última expresión es lo que devuelve. No existe return.
{ val a = 1; { val b = a * 2; { val c = b + 4; c } } }

//Condicionales
val a = 1
val b = 2
if(a > b) a else b

val x = 1
val y = 2
match {
  case 1 => true
  case 2 => false
}

val day = "MON"
val kind = day match {
  case "MON" | "TUE" | "WED" | "THU" | "FRI" => "weekday"
  case "SAT" | "SUN" => "weekend"
  case _ => "null"
}

//Ojo a la "s" automaticamente por "response"
//Y los if en los case sin "()"
val response: String = null
response match {
  case s if s != null => println(s"Received '$s'")
  case s => println("Error! Received a null response")
}

val x: Int = 12180
val y: Any = x
y match {
//  case x: String => s"'x'"
  case x: String => s"$x"
  case x: Double => f"$x%.2f"
  case x: Float => f"$x%.2f"
  case x: Long => s"${x}l"
  case x: Int => s"${x}i"
}

//for (<identifier> <- <iterator>) [yield] [<expression>]
//"yield" nos devuelve una colección/vector
for (luis <- 1 to 7) {
  println(s"Dia $luis:\n")
}

for (luis2 <- 1 to 7) yield {
  s"Dia $luis2:"
}

//Iterator Guard. Filtrando las iteraciones con "if"
val quote = "Pedro,Alonso,Jose"
for {
  t <- quote.split(",")
  if t != null
  if t.size > 0
}
println(t)

//En una colección con "yield"
val quote = "Pedro,Alonso,Jose"
for {
  t <- quote.split(",")
  if t != null
  if t.size > 0
}
yield t

val threes = for (i <- 1 to 20 if i % 3 == 0) yield i

//For anidado
for { m <- 1 to 2
      n <- 1 to 3 }
{ print(s"($m,$n) ") }

//Bucle RANGE
val caraja = 1 to 10
val caraja2 = 1 to 10 by 2

//while (<Boolean expression>) statement
//comprueba primero y luego ejecuta
var R = 20
while( R > 10 ){
  println("Valor de I es: " + R )
  R = R - 2
}

//do statement while (<Boolean expression>)
//ejecuta primero y luego comprueba
var I = 20
do{
  println("Valor de I es: " + I )
  I = I - 2
} while( I > 10 )
