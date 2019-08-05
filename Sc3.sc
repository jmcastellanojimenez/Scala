//Colecciones inmutables. Listas
val numbers = List(32, 95, 24, 21, 17)
val colors = List("rojo", "verde", "azul")
val numeros = 10 :: 20 :: 30 :: 40 :: Nil

// “size” sobre una colección o String nos devuelve el número de ítems
println(s"Tengo ${colors.size} colores: $colors")

//Lista de listas
val oddsAndEvents = List(List(1, 3, 5), List(2, 4, 6))

//Listas de Tuplas de 2 ítems. Son similares a los Map
val keyValues = List(('A', 65), ('B',66), ('C',67))

//acceder a un elemento, invocándole como una función con índice (zerobased).
val first = oddsAndEvents(0)
val fourth = keyValues(2)

//head() y tail() para acceder al primer miembro y a los restantes.
//Util cabecera ficheros de datos
val primos = List(2, 3, 5, 7, 11, 13)
val first = primos.head
val remaining = primos.tail

//Tres formas de recorrer una Lista: isEmpty, función y Nil.
var i = primos

while(! i.isEmpty) { print(i.head + ", "); i = i.tail }

def visit(i: List[Int]) { if (i.size > 0) { print(i.head + ", "); visit(i.tail) } }
visit(primos)

while(i != Nil) { print(i.head + ", "); i = i.tail }

//Concatena listas
val a = List(1,2,3)
val b = List(4,5,6)
val c = a ++ b
val c = a ::: b
val c = List.concat(a, b)

// "fill" rellena Listas y tabulate crea listas con la función que se le pase
val x = List.fill(3)(7)
//la funcion calcula el cuadrado de la posición
val x = List.tabulate(5)(n => n * n)

//CONJUNTOS ó sets: es una colección inmutable y desordenada de elementos únicos
//Soporta las mismas operaciones que las Listas
val unique = Set(10, 20, 30, 20, 20, 10)
val sum = unique.reduce( (a: Int, b: Int) => a + b )

//head Devuelve el primer elemento de un Set.
//tail Devuelve un Set con todos los elementos menos el primero.
//isEmpty Devuelve true si el Set es vacío. False en otro caso.
//Set.++() Devuelve un nuevo Set concatenando dos o más Sets.
//Set.min Devuelve el mínimo valor de un Set.
//Set.max() Devuelve el máximo valor de un Set.
//Set.intersect Devuelve los valores comunes de los dos Sets.
//Set.& Devuelve los valores comunes de los dos Sets.
//Ejemplo
val d = a.++(b)

//MAPAS ó diccionarios
//la clave y el valor están parametrizados por tipo
val colorMap = Map("red" -> 0xFF0000, "green" -> 0xFF00, "blue" -> 0xFF)
val colorMap2 = Map(("red",0xFF0000),("green",0xFF00),("blue",0xFF))

//keys          Devuelve un iterable conteniendo las claves del Map.
//values        Devuelve un iterable conteniendo los valores del Map.
//isEmpty       Devuelve true si el Map es vacío. False en otro caso.
//Map.++()      Devuelve un nuevo Map concatenando dos o más Maps.
//Map.contains  Comprueba si una clave existe en el Map.
//Foreach loop  Se usa para imprimir las claves y valores de un Map.

// FILTER       para agrupar, devuelve una lista según la funcion pasada
// PARTITION    igual pero devuelve dos listas: los que cumplen y los que no


//Mapeo de funciones --> asociacion entre cada elemento de los dos conjuntos

// COLLECT
// List(0, 1, 0) collect {case 1 => "ok"}
// Transforma cada elemento usando una función parcial y quedándose con
//los elementos que aplican.
List(0, 1, 0) collect {case 1 => "ok"}

//FLATMAP
//List("milk,tea") flatMap (_.split(','))
//Transforma cada elemento usando una función dada y devuelve el
//resultado en una única lista
List("milk,tea") flatMap (_.split(','))
//MAP
//List("milk","tea") map (_.toUpperCase)
//Transforma cada element usando la función dada.
List("milk","tea") map (_.toUpperCase)


//OPERACIONES DE REDUCCION Matemáticas
//Operaciones de reducción a Booleano
//OPERACIONES GENERICAS DE REDUCCION
//OPERACIONES DE CONVERSION
//https://www.scala-lang.org/api/current/scala/collection/immutable/List.html
