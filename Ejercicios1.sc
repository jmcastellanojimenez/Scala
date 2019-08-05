//1. Imprime los números del 1 to 100, en grupos de 5 por línea.
for (i <- 1 to 100 by 5) {
  for (j <- i to (i + 4)) { print(s"$j, ") }
  println("")
}

//2. Escribe una expresión que imprima los números del 1 a 100, excepto para
//los múltiplos de 3, imprima “trio”, los de 5 “cinco” y para los múltiplos
//de 3 y 5 “trio y cinco”. Puedes escribirlo en una línea?

for (x <- 1 to 100){
  x match {
    case x if x % 3 == 0 => print("Trio")
    case x if x % 5 == 0 => print("Cinco")
    case x if x % 3 == 0 & x%5 == 0 => print("Trio y cinco")
    case _ => print(x)
  }
}

for (i <- 1 to 100) {
  var s = i.toString;
  if (i%5==0) s="cinco";
  if (i%3==0) s = "trio";
  if (i%15==0) s="trio y cinco";
  println(s) }

//3. Escribir una nueva conversión centígrados/Fahrenheit, usando la formula (x * 9/5) + 32
// en valores separados. Sacar el resultado en Entero y en Float.

val celsius = 7
val fahr1 = celsius * 9
val fahr2 = fahr1 / 5.0
val fahrenheit = fahr2 + 32

val fahr2 = fahr1 / 5
val fahrenheit = fahr2 + 32

//4. Usar el valor de entrada 3.4657 y generar el String “Prestame $3.46 dolares”.
val entrada = 3.4657
f"Prestame $$$entrada%.2f dolares"

//5. Convertir el número 128 a Char, a String y a Double. Volverlo a convertir a Int.
val numero = 128
numero.toChar
numero.toString
numero.toDouble
numero

//6. Dado un String, escribir una expresión match que
//devuelva el String si no es vacío o “n/a” si es vacío.
val cadena = Unit
cadena match {
  case Unit => raw"n/a"
  case _ => print(cadena)
}

//7. Dada una cantidad, escribir una expresión que devuelva “mayor” si es mayor que 0, “igual”
// si es cero y“menor” si es menor que 0. Escribir la expresión con match y con bloques if else.

val expresion = 0
expresion match {
  case e if e > 0 => print("mayor")
  case e if e < 0 => print("menor")
  case e if e == 0 => print("igual")
}
