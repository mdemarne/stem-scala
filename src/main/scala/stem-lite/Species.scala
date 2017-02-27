package stemLite
import stem._

import scala.util.Random

/**
 * Implementation of a spieces as being a random integer if not passed as
 * parameters.
 * @author mdemarne (mdemarne@outlook.com)
 */
case class Species(val id: String = (new Random()).nextInt.toString)
  extends contract.mutation.Species {
}
