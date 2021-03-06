import scala.annotation.tailrec

object s23787_cw1 extends App {
  val dniList = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  println("Zadanie 1.a)")
  for (element <- dniList) {
    if (dniList.indexOf(element) != dniList.length - 1) {
      print(element + ", ")
    } else {
      print(element)
      println()
    }
  }

  println("1.b)")
  for (element <- dniList) {
    if (element.charAt(0).equals('P')) {
      print(element + ", ")
    }
  }
  println()

  println("1.c)")
  var index: Int = 0
  var dniCombined: String = ""
  while (index < dniList.length) {
    dniCombined += dniList(index) + ", "
    index += 1
  }
  println(dniCombined)

  println("Zadanie 2.a)")

  def dniPrint(dniList: List[String]): String = {
    var dniComb = dniList(0);

    if (dniList.length > 1) {
      var printList = dniList.tail
      dniComb += ", " + dniPrint(printList)
    }
    dniComb
  }

  println(dniPrint(dniList))

  println("Zadanie 2.b)")

  def dniPrintRev(dniList: List[String]): String = {
    var dniComb = dniList.last

    if (dniList.length > 1) {
      var printedList = dniList.dropRight(1)
      dniComb += ", " + dniPrintRev(printedList)
    }
    dniComb
  }

  println(dniPrintRev(dniList))


  println("Zadanie 3)")

  def dniPrintTail(dniList: List[String]): String = {
    @tailrec
    def iter(list: List[String], dniComb: String): String = {
      if (list.isEmpty) {
        dniComb
      } else {
        iter(list.tail, dniComb + list.head + ", ")
      }
    }

    iter(dniList, "")
  }

  println(dniPrintTail(dniList))

  println("Zadanie 4.a)")
  println(dniList.foldLeft("")(_ + _ + ", "))

  println("Zadanie 4.b)")
  println(dniList.foldRight("")(_ + ", " + _))

  println("Zadanie 4.c)")
  println(dniList.filter(x => x.startsWith("P")).fold("")(_ + _ + ", "))

  println("Zadanie 5")
  val produkty = Map("Dżem" -> 10.0, "Truskawki" -> 5.0, "Delma" -> 20.0)
  val produktMap = produkty map { case (k, v) => (k, 0.9 * v) }
  println(produkty)
  println(produktMap)

  println("Zadanie 6")
  val tupla1 = Tuple3(false, "tekst", 15)

  def printTuple(tuple: Tuple3[_, _, _]): String = {
    return tuple._1.toString + " " + tuple._2 + " " + tuple._3 + " "
  }

  println(printTuple(tupla1))

  println("Zadanie 7")
  println(produkty.getOrElse("Dżem", false))

  println("Zadanie 8")
  val intList = List(0, 2, 0, 5, 99, 100, 0)
  println(intList.filter(x => x != 0))

  println("Zadanie 9")
  println(intList.map((x) => x + 1))


  println("Zadanie 10")
  val realList = List(0, -2.5, 3.14, -5.33, 9.9, -4.1)
  println(realList.filter((x) => x <= 12 && x >= -5).map(x => Math.abs(x)))


}
