
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;

import net.cwroethel.swt.popupcalendar.DateChooser;
import net.cwroethel.swt.popupcalendar.PopupCalendar;
import java.text.SimpleDateFormat;


public class DateChooserExample1 {
  public static void main(String[] args) {
    
    // set up the display and the main shell
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, true));
    
    
    // We want to put all the following widgets in a composite to demonstrate
    // that the widget can be placed in something other than a shell.
    Composite contentsPane = new Composite(shell, SWT.LEFT_TO_RIGHT);
    contentsPane.setLayout(new GridLayout(1, true));

    
    // now we create the calendar widget
    final DateChooser dateChooser = new DateChooser(contentsPane,
        PopupCalendar.SHOWALL | SWT.CENTER);

    
    // Since DateChooser allows to customize it's components we need to 
    // explicitly call paint to tell that we're done configuring the widget
    // and want to have it drawn. After drawing most changes will be ignored.
    dateChooser.paint();
    dateChooser.setLayoutData(new GridData(GridData.FILL_BOTH));


    // add a submit button below the calendar
    Button submit = new Button(contentsPane, SWT.PUSH);
    submit.setLayoutData(new GridData(GridData.FILL_BOTH));
    submit.setText("Submit");
    

    // when the button is pressed read the date in the dateChooser.
    submit.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event) {
        // need to check this since selecting no date is a valid (non-)operation.
        if (dateChooser.getDate() != null) {
          MessageBox msgBox = new MessageBox(shell, SWT.ICON_INFORMATION);
          msgBox.setMessage("Date Selected: " +
              new SimpleDateFormat("EEE MM/dd/yy").format(
                  dateChooser.getDate().getTime()));
          msgBox.open();
          // reset the selected day.
          dateChooser.resetDates();
         }
        else {
          MessageBox msgBox = new MessageBox(shell, SWT.ICON_WARNING);
          msgBox.setMessage("No Date Selected!");
          msgBox.open();
        }
      }
    });


    // dateChooser.paint();
    shell.pack();
    shell.open();


    // run the loop.
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }
}
