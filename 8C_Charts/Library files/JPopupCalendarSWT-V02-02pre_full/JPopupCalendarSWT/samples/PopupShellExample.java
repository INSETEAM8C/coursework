
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;

import net.cwroethel.swt.popupcalendar.*;

public class PopupShellExample {

  public static void main(String[] args) {
    
    // Set up the display and the shell
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, true));
    

    // add a contents pane - We want to do that to show how to add
    // a popup window to an arbitrary widget.
    Composite contentsPane = new Composite(shell, SWT.LEFT_TO_RIGHT);
    contentsPane.setLayout(new GridLayout(2, true));
    

    // create a popup shell manager and set the layout of the shell.
    // The shell can now be used like any other shell. To open it 
    // use the openShell() method of PopupShell.
    final PopupShellManager popupShell = 
      new PopupShellManager(contentsPane.getShell());    
    popupShell.getShell().setLayout(new GridLayout(1, true));
 

    // add a button to open the shell.
    Button select = new Button(contentsPane, SWT.PUSH);
    select.setLayoutData(new GridData(GridData.FILL_BOTH));
    select.setText("Select Date");
    select.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event) {
        Control comp = (Control)event.getSource();
        popupShell.openShell(comp, SWT.RIGHT);
      }
    });

    // add a button in the shell.
    Button popupButton = new Button(popupShell.getShell(), SWT.PUSH);
    popupButton.setLayoutData(new GridData(GridData.FILL_BOTH));
    popupButton.setText("Push Me");
    
    // hide the shell when the button is pressed. 
    popupButton.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event) {
        popupShell.getShell().setVisible(false);
      }
    });
        
    // This button is just decoration. Don't know why it's there...
    Button submit = new Button(contentsPane, SWT.PUSH);
    submit.setLayoutData(new GridData(GridData.FILL_BOTH));
    submit.setText("Submit");
    submit.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event) {
      }
    });

    // you could try this before opening the popup window if that 
    // turns out to be slow. But shouldn't be needed in general.
    // popupShell.getShell().pack();
    
    // draw the main shell
    shell.pack();
    shell.open();

    // start the event loop
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }
}
