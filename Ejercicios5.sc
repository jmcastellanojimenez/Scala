//1. Crear una Clase Scala que tenga:
//a) Tres atributos: Nombre, Apellidos, Edad.
//b) Tres constructores con 1, 2 y 3 parámetros de entrada.
//c) Sobrecargue el método toString

class Persona(val nombre: String,val apellido: String,val edad: Int){
  // Constructor 2.
  def this(nombre: String) {
    this(nombre, "", 0)
    println("\nSin apellidos, ni edad.")
  }
  // Constructor 3.
  def this(nombre: String, apellido: String) {
    this(nombre, apellido, 0)
    println("\nSin edad.")
  }
  override def toString: String = {
    "%s %s, age %d".format(nombre, apellido, edad)
  }
}

// (1) Uso del primer constructor
val al = new Persona("Alvin", "Alexander", 20)
println(al)
// (2) Uso del segundo constructor
val barney = new Persona("Barney")
println(barney)
// (3)Uso del tercer constructor
val fred = new Persona("Fred", "Flinstone")
println(fred)
