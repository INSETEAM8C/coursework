
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;

import net.cwroethel.swt.popupcalendar.PopupCalendar;
import java.text.SimpleDateFormat;


public class SimpleExample1 {
  public static void main(String[] args) {
    
    // set up a display and a shell.
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, true));
    

    // put everything in a composite. Just to illustrate how to add the 
    // popup calendar from any widget.
    Composite contentsPane = new Composite(shell, SWT.LEFT_TO_RIGHT);
    contentsPane.setLayout(new GridLayout(2, true));
    

    // create the popup calendar
    final PopupCalendar popupCal = new PopupCalendar(contentsPane.getShell(),
        PopupCalendar.SHOWALL);    


    // add a button to open the popup calendar
    Button select = new Button(contentsPane, SWT.PUSH);
    select.setLayoutData(new GridData(GridData.FILL_BOTH));
    select.setText("Select Date");
    select.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event) {
        Control comp = (Control)event.getSource();
        // open the calendar window with the right edges aligned 
        // (if there's space).
        popupCal.open(comp, SWT.RIGHT);
      }
    });


    // add the submit button that triggers reading out the selected date.
    Button submit = new Button(contentsPane, SWT.PUSH);
    submit.setLayoutData(new GridData(GridData.FILL_BOTH));
    submit.setText("Submit");
    submit.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event) {
        
        // we need to check if a date was actually selected. null is 
        // an allowed value.
        if (popupCal.getDate() != null) {
          MessageBox msgBox = new MessageBox(shell, SWT.ICON_INFORMATION);
          msgBox.setMessage("Date Selected: " +
              new SimpleDateFormat("EEE MM/dd/yy").format(popupCal.getDate().getTime()));
          msgBox.open();
          
          // I want to reset all dates stored in the calendar.
          popupCal.resetDates();
         }
        else {
          MessageBox msgBox = new MessageBox(shell, SWT.ICON_WARNING);
          msgBox.setMessage("No Date Selected!");
          msgBox.open();
        }
      }
    });


    // open the shell
    shell.pack();
    shell.open();

    // main event loop
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }
}
