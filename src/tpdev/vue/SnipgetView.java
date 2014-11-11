package tpdev.vue;

import horloge.text.HorlogeTexte;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class SnipgetView extends ViewPart {

   public SnipgetView() {
      // TODO Auto-generated constructor stub
   }

   @Override
   public void createPartControl(Composite parent) {
	   new HorlogeTexte(parent);
   }

   @Override
   public void setFocus() {
      // TODO Auto-generated constructor stub
   }

}