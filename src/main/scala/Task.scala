case class Task[T](description: T)

abstract class TaskType(val description: String) {
  def display(): String //abstract class for defining types of task
}

//This class defines a Normal Task
class NormalTask(description: String) extends TaskType(description) {
  override def display(): String = s"Task: $description"
}

class ImportantTask(description: String, val priority: Int) extends TaskType(description) {
  override def display(): String = s"[$priority] Task: $description"
}