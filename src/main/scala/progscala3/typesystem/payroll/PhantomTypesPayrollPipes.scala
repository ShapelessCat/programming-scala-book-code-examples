// src/main/scala/progscala3/typesystem/payroll/PhantomTypesPayrollPipes.scala
package progscala3.typesystem.payroll

import progscala3.contexts.accounting.*
import scala.annotation.targetName

object Pipeline:
  extension [V, R](value: V)
    @targetName("pipe") def |> (f: V => R) = f(value)

@main def TryPhantomTypesPipeline =
  import Pipeline.*
  import Payroll.*

  val e = Employee(
    name = "Buck Trends",
    annualSalary = Dollars(100000.0),
    taxRate = Percentage(25.0),
    insurancePremiums = Dollars(200),
    _401kDeductionRate = Percentage(10.0),
    postTaxDeductions = Dollars(100.0)
  )
  val pay = start(e)  |>
    deduct401k        |>
    deductInsurance   |>
    deductTax         |>
    deductFinalDeductions
  println(e); println(pay)
