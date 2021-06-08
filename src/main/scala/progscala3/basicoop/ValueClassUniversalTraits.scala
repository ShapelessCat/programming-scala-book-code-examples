package progscala3.basicoop

trait Digitizer extends Any:
  def digits(s: String): String =                                    // <1>
    s.replaceAll("""\D""", "")

trait Formatter extends Any:                                         // <2>
  def format(areaCode: String, exchange: String, subnumber: String): String =
    s"($areaCode) $exchange-$subnumber"

case class NAPhoneNumberUT(s: String) extends AnyVal with Digitizer with Formatter:
  override def toString =
    val digs = digits(s)
    val areaCode = digs.substring(0,3)
    val exchange = digs.substring(3,6)
    val subnumber  = digs.substring(6,10)
    format(areaCode, exchange, subnumber)                            // <3>
