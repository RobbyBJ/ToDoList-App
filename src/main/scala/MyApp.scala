import scalafx.application.JFXApp.PrimaryStage
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafxml.core.{FXMLLoader, NoDependencyResolver}
import javafx.{scene => jfxs}
import scalafx.Includes._

object MyApp extends JFXApp {

  val rootResource = getClass.getResource("ToDoList.fxml")
  val loader= new FXMLLoader(rootResource, NoDependencyResolver)
  loader.load()
  val roots = loader.getRoot[jfxs.layout.BorderPane]

  val css = getClass.getResource("style.css").toExternalForm
  roots.getStylesheets.add(css)

  stage = new PrimaryStage {
    title = "To-Do List App"
    scene = new Scene() {
      root = roots
    }
  }
}