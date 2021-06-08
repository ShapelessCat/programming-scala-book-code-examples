package progscala3.introscala                                   // <1>

object UpperMain1:
  def main(params: Array[String]): Unit =                       // <2>
    output("UpperMain1.main: ")(params)

def main(params: Array[String]): Unit =                         // <3>
  output("main: ")(params)

@main def Hello(params: String*): Unit =                        // <4>
  output("Hello: ")(params.toArray)

private def output(header: String)(data: Array[String]): Unit =
  print(header)
  data.map(s => s.toUpperCase).foreach(s => printf("%s ", s))
  println("")
