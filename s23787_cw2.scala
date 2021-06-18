object s23787_cw2 extends App {

  println("Zadanie 1")

  def zad1(dzien: String): String = dzien match {
    case "Poniedziałek" => "Praca"
    case "Wtorek" => "Praca"
    case "Środa" => "Praca"
    case "Czwartek" => "Praca"
    case "Piątek" => "Praca"
    case "Sobota" => "Weekend"
    case "Niedziela" => "Weekend"
    case _ => "Brak takiego dnia"
  }

  println(zad1("Poniedziałek"))
  println(zad1("Niedziela"))
  println(zad1("Lipiec"))


  println("Zadanie 2")

  class KontoBankowe(val stanInit: Float) {
    private var stanKonta: Float = stanInit

    def this() {
      this(0f)
      stanKonta = this.stanInit
    }


    def wyplata(value: Float) {
      if (value > stanKonta) {
        println("Brakuje " + (value - stanKonta) + " do wypłaty")
      } else {
        stanKonta -= value
      }
    }

    def wplata(value: Float) {
      stanKonta += value
    }

    def getStanKonta(): String = {
      this.stanKonta.toString
    }

  }

  var konto1 = new KontoBankowe()
  var konto2 = new KontoBankowe(1500f)
  konto1.wyplata(300)
  konto2.wplata(500)
  println(konto1.getStanKonta())
  println(konto2.getStanKonta())


  println("Zadanie 3")

  case class Osoba(imie: String, nazwisko: String)

  def osobaPrzywitanie(osoba: Osoba): String = (osoba.imie, osoba.nazwisko) match {
    case ("Jan", "Kowalski") => "Serwus Jan!"
    case ("Andrzej", "Nowak") => "Czołem Andrzej"
    case (imie, nazwisko) => "Witaj " + imie + " " + nazwisko + "!"
  }

  val osoba1 = new Osoba("Jan", "Kowalski")
  val osoba2 = new Osoba("Andrzej", "Nowak")
  val osoba3 = new Osoba("Pawel", "Jaki")
  println(osobaPrzywitanie(osoba1))
  println(osobaPrzywitanie(osoba2))
  println(osobaPrzywitanie(osoba3))

  println("Zadanie 4")

  def zad4 (liczba: Int, f: (Int) => Float): Float ={
    f(liczba)
  }

  println(zad4(2,(x)=> x^2+3))

  println("Zadanie 5")
  class Osoba5(val imie: String, val nazwisko: String){
    val _podatek: Double = 0
    def podatek: Double = _podatek

    override def toString: String = this.imie + " " + this.nazwisko + " podatek: " + this.podatek
  }

  trait Pracownik extends Osoba5{
    var pensja: Double = 0
    override def podatek: Double = pensja * 0.2
  }

  trait Nauczyciel extends Pracownik {
    override def podatek: Double = pensja * 0.1
  }

  trait Student extends Osoba5{
    override def podatek: Double = 0
  }

  val o1 = new Osoba5("Andrzej","Nowak") with Student
  val o2 = new Osoba5("Jan","Kowalski") with Pracownik
  o2.pensja = 10000
  val o3= new Osoba5("Szymon", "Malecki") with Nauczyciel
  o3.pensja = 10000
  println(o1.toString)
  println(o2.toString)
  println(o3.toString)


}
