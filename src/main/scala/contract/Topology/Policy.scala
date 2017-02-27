package stem.contract.topology
import stem.contract._

/**
 * This object represents the policy to apply in a given stem actor.
 * @author mdemarne (mdemarne@outlook.com)
 */
object Policy  {
  trait Value
  case object Elastic extends Value
  case class Static(nbCells: Int) extends Value
}
