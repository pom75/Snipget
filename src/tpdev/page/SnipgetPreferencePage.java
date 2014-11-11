package tpdev.page;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class SnipgetPreferencePage extends PreferencePage
       implements IWorkbenchPreferencePage {

       protected Control createContents(Composite parent) {
            Composite composite = new Composite(parent, SWT.NONE);
            Color jaune = parent.getDisplay().getSystemColor(SWT.COLOR_YELLOW);
            composite.setBackground(jaune);
            return composite;
      }


	public void init(IWorkbench arg0) {
		// TODO Auto-generated method stub
		
	}

}