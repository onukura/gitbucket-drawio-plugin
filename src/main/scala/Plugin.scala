import javax.servlet.ServletContext

import gitbucket.core.plugin.PluginRegistry
import gitbucket.core.service.SystemSettingsService
import gitbucket.core.service.SystemSettingsService.SystemSettings
import io.github.gitbucket.solidbase.model.Version

import scala.util.Try

class Plugin extends gitbucket.core.plugin.Plugin {
  override val pluginId: String = "drawio"
  override val pluginName: String = "Draw.io renderer Plugin"
  override val description: String = "Rendering drawio files."
  override val versions: List[Version] = List(
    new Version("0.1.0"),
  )

  private[this] var renderer: Option[DrawioRenderer] = None

  override def initialize(registry: PluginRegistry, context: ServletContext, settings: SystemSettingsService.SystemSettings): Unit = {
    val test = Try{ new DrawioRenderer() }
    val drawio = test.get
    registry.addRenderer("drawio", drawio)
    renderer = Option(drawio)
    super.initialize(registry, context, settings)
  }

  override def shutdown(registry: PluginRegistry, context: ServletContext, settings: SystemSettings): Unit = {
    renderer.foreach(r => r.shutdown())
  }

  override val assetsMappings = Seq("/drawio" -> "/drawio/assets")

}
