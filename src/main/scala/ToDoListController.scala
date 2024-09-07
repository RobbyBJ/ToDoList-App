import scalafx.scene.control.{Button, Label, ListView, TextField}
import scalafxml.core.macros.sfxml
import scalafx.collections.ObservableBuffer

@sfxml
class ToDoListController
( private val taskInput: TextField,
  private val addButton: Button,
  private val taskListView: ListView[String],
  private val removeButton: Button,
  private val clearButton: Button,
  private val sizeLabel: Label
) {

  // Initialize the task list, with type String
  private val taskList = new SimpleTaskList[String]
  private val observableTasks = ObservableBuffer[String]()
  taskListView.items = observableTasks

  // Initialize button actions when interacted
  addButton.onAction = _ => addTask()
  removeButton.onAction = _ => removeTask()
  clearButton.onAction = _ => clearAllTasks()

  // Add a new task
  private def addTask(): Unit = {
    val taskDescription = taskInput.text()
    if (taskDescription.nonEmpty) {
      val task = Task(taskDescription)
      taskList.add(task)
      observableTasks += taskDescription
      taskInput.clear()
      updateTaskCount()
    }
  }

  // Remove the selected task
  private def removeTask(): Unit = {
    val selectedTask = taskListView.selectionModel().getSelectedItem
    if (selectedTask != null) {
      taskList.remove()
      observableTasks -= selectedTask
      updateTaskCount()
    }
  }

  // Clear all tasks
  private def clearAllTasks(): Unit = {
    taskList.clear()
    observableTasks.clear()
    updateTaskCount()
  }

  // Update the total number of tasks displayed
  private def updateTaskCount(): Unit = {
    sizeLabel.text = s"Total Tasks: ${taskList.size()}"
  }
}