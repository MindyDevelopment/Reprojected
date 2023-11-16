package re

import arc.*
import arc.util.*
import arc.files.*
import arc.scene.ui.*
import arc.scene.event.*
import mindustry.*
import mindustry.mod.*
import mindustry.game.*
import mindustry.ui.*
import mindustry.ui.dialogs.*
import com.github.mnemotechnician.mkui.extensions.dsl.*
import com.github.mnemotechnician.mkui.extensions.groups.*

class Reprojected : Mod(){

	init{
		Events.on(EventType.ClientLoadEvent::class.java){
			val info = BaseDialog("@reprojected-dialog.info").apply{
				closeOnBack()
				addCloseButton()
				
				cont.apply{
					addLabel("@reprojected-dialog.unfinished", wrap = true).growX().row()
					
					textButton("@reprojected-dialog.repo"){
						Core.app.openURI("https://github.com/MindyDevelopment/Reprojected")
					}.row()
					
					var invis = 0
					
					textButton("@reprojected-dialog.delete"){
						if(OS.isWindows){
							setText("@reprojected-dialog.delete-incompatible")
							touchable = Touchable.disabled
							return@textButton
						}
						
						file().delete()
						invis++
						
						when(invis){
							1 -> setText("@reprojected-dialog.exit")
							2 -> Core.app.exit()
						}
					}
				}
			}

		info.show()
		}
	}
	
	fun loadedMod() = Vars.mods.getMod(this::class.java)
	
	fun file() = loadedMod().file
}
