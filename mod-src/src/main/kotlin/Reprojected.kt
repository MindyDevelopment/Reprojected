package re

import arc.*
import arc.scene.ui.*
import mindustry.mod.*
import mindustry.game.*
import mindustry.ui.*
import mindustry.ui.dialogs.*
import com.github.mnemotechnician.mkui.extensions.dsl.*
import com.github.mnemotechnician.mkui.extensions.groups.*

class Reprojected : Mod() {

	init {
	    Events.on(ClientLoadEvent::class.java){
	        val info = BaseDialog("@reprojected-dialog.info").apply{
	            closeOnBack()
	            addCloseButton()
	            
	            cont.apply{
	                addLabel("@reprojected-dialog.unfinished", wrap = true).growX().row()
	                
	                textButton("@reprojected-dialog.repo", wrap = false){
	                    Core.app.openURI("https://github.com/MindyDevelopment/Reprojected")
	                }
	            }
	        }
	    }
	}
	
}
