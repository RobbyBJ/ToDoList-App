import scala.collection.mutable.ListBuffer

trait TaskList[T] {
  def add(task: Task[T]): Unit
  def remove(): Option[Task[T]]
  def size(): Int
  def clear(): Unit
}

class SimpleTaskList[T] extends TaskList[T] {
  private val tasks: ListBuffer[Task[T]] = ListBuffer()

  override def add(task: Task[T]): Unit = {
    tasks += task
  }

  override def remove(): Option[Task[T]] = {
    if (tasks.nonEmpty) Some(tasks.remove(0)) else None
  }

  override def size(): Int = tasks.size

  override def clear(): Unit = {
    tasks.clear()
  }
}