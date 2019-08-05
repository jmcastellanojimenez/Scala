//1. Crear una Lista con los primeros 20 números impares. Probar con un for, una
// operación filter y una map.
//Cada vuelta del FOR el YIELD lo mete en un vector (lista)
for (i <- 0L to 9L; j = i * 2 + 1) yield j
//Tambien accediendo al metodo el iterable ->   (0L to 20L).filter (_ % 2 == 1)
0L to 20L filter (_ % 2 == 1)
0L to 9L map (_ * 2 + 1)

//2. Escribir una función llamada “factors” que coja un número y devuelva sus
// factores que no sean ni 1 ni él mismo. Por ejemplo factors(15) debe devolver
// List(3, 5). Escrribir una nueva función que aplique “factors” a una lista de
// números. Por ejemplo ejecutando la función con
// List(9, 11, 13, 15) debe devolver List(3, 3, 5).
// 2 to (x-1) --> La secuencia que devuelve expcepto 1 y él mismo!!
def factors(x: Int) = { 2 to (x-1) filter (x % _ == 0) }
//Para recibir la lista!!
//def uniqueFactors(l: Seq[Int]) = l.flatMap(factors)
def uniqueFactors(l: Seq[Int]) = l flatMap factors
uniqueFactors(List(9, 11, 13, 15))


//3. Escribir una función first[A](items: List[A], count: Int): List[A], que
// devuelva los primeros “count” número de elementos de una lista. Por ejemplo
// first(List('a','t','o'), 2) debe devolver List('a','t').
// TAKE Extrae los primeros n elementos de la lista
val chars = ('a' to 'f').toList

def first[A](items: List[A], count: Int): List[A] = items.take(count)
first(chars, 3)

//ó

def first[A](items: List[A], count: Int): List[A] = {
  val l = for (i <- 0 until count) yield items(i)
  l.toList
}
first(chars, 3)

//4. Escribir una función que coja una lista de Strings y devuelva el de mayor longitud.
def longest(l: List[String]): String = l.sortBy(0 - _.size).head
val names = List("Anton", "Pedro", "Juan", "Roberto")
longest(names)

//Usando fold
def longest(l: List[String]): String = {
  l.fold("")((a,i) => if (a.size < i.size) i else a)
}

longest(names)

//Usando Reduce
def longest(l: List[String]): String = {
  l.reduce((a,i) => if (a.size < i.size) i else a)
}
longest(names)


//5. Escribir una función que dé la vuelta a una lista.
def reverse[A](src: List[A], dest: List[A] = Nil): List[A] = {
  if (src == Nil) dest else reverse(src.tail, src.head :: dest)
}
val nombres = List("Antonio", "Pedro", "Juan", "Enrique")
reverse(nombres)


//6. Escribir una función que coja una List[String] y devuelva una
// (List[String],List[String]), siendo la primera lista los que son
// palindromos y la segunda los que no lo son.
def splitPallies(l: List[String]) = l partition (s => s == s.reverse)
val pallies = List("Hola", "otto", "yo", "racecar")
splitPallies(pallies)
