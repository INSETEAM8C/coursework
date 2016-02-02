
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;

import net.cwroethel.swt.popupcalendar.*;

import java.text.SimpleDateFormat;

/**
 * This example shows how to select a date from a popup window and
 * display it in a a Text widget.
 * @author Will
 *
 */

public class SimpleExample2 {

  public static void main(String[] args) {
    
    // Create the display and a shell
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(2, false));
    
    
    // create the popup calendar
    final PopupCalendar popupCal = new PopupCalendar(shell, PopupCalendar.SHOWALL);


    // Create the Text widget to show the selected date
    final Text showDate = new Text(shell, SWT.CENTER | SWT.READ_ONLY );
    GridData data = new GridData();
    data.widthHint = 80;
    data.heightHint = 20;
    showDate.setLayoutData(data);
    showDate.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));


    // Create the button to trigger the popup window
    Button select = new Button(shell, SWT.PUSH);
    select.setLayoutData(new GridData(GridData.FILL_BOTH));
    select.setText("Select Date");
    select.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event) {
        Control comp = (Control)event.getSource();
        
        // open the popup window - right edge of the window should be
        // aligned with the button that triggered it.
        popupCal.open(comp, SWT.RIGHT);
      }
    });

    // add a selection listener to the popup calendar. 
    popupCal.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event) {
        
        // if the calendar was selected, read out the date. 
        // Date can be 'null'
        if (popupCal.getDate() != null) {
          showDate.setText(new SimpleDateFormat("EEE MM/dd/yy").format(
              popupCal.getDate().getTime()));         
        }
      }
    });

    // a little trick to speed up opening the window
    popupCal.getDateChooser().paint(); // remember the popup shell is not visible yet :)
    
    
    // set text and initial focus. Open the shell.
    select.setFocus();
    shell.setText("PopupCalendar Example");
    shell.pack();
    shell.open();


    // main event loop.
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }
}
