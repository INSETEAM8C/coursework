
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import java.text.SimpleDateFormat;
import java.util.Locale;

import net.cwroethel.swt.popupcalendar.*;

/**
 * This example shows the basics on how to customize the popup calendar.
 * The locale should be 'French'. The background of the day labels shown in 
 * the calendar should be red. Further the labels to show the days should be 
 * customized. This example is based on SimpleExample2. See more there for 
 * details on the basic use. 
 * @author Will
 *
 */
public class SimpleExample3 {

  public static void main(String[] args) {
    
    // Create the display and open a shell.
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(2, false));
    
    
    // create the popup calendar.
    final PopupCalendar popupCal = new PopupCalendar(shell, PopupCalendar.SHOWALL, 
        Locale.FRENCH);


    // create the Text widget.
    final Text showDate = new Text(shell, SWT.CENTER | SWT.READ_ONLY);
    GridData data = new GridData();
    data.widthHint = 80;
    data.heightHint = 20;
    showDate.setLayoutData(data);
    showDate.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));


    // create the button to open the popup window.
    Button select = new Button(shell, SWT.PUSH);
    select.setLayoutData(new GridData(GridData.FILL_BOTH));
    select.setText("Select Date");
    select.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event) {
        Control comp = (Control)event.getSource();
        popupCal.open(comp, PopupCalendar.RIGHT);
      }
    });


    // change the buttons of the current month to red and make the buttons
    // 30 pixels wide (the remaining buttons will adjust since all is put into
    // an equal-sized GridLayout

    // start customizing the popup calendar
    // Customize the day selectors (The thing that shows the days in the 
    // calendar.). Use the DaysSelectorStyleAdapter for that.
    
    // Create the color used to set the style below. We create our own color
    // to demonstrate that we still are responsible for disposing these custom
    // colors.
    final Color red = new Color(Display.getCurrent(), 255, 127, 127);
    
    // add the adapter.
    popupCal.setDaySelectorStyle(new DaySelectorStyleAdapter() {
      
      // This is the method used to override the defaults. The 'style' here
      // refers to the different components of the day selector.
      public void overrideStyle(Control control, int style) {
        switch (style) {
          // The DAYLABEL is the label showing the days of the current month.
          case DaySelectorStyle.DAYLABEL:
            // set the background color
            control.setBackground(red);
            
            // Make the labels 30 pixels wide.
            ((GridData) control.getLayoutData()).widthHint = 30;
            break;
        }
      }
    });
    
    // Now update the weekday names. The array must contain 7 elements otherwise
    // an an exception is cast.
    try {
      popupCal.getDaySelectorStyle().setWeekdayNames(
          new String[] {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"});
    } catch (Exception e) {
      System.out.println(e);
    }

    // Now customize the 
    popupCal.setMonthSelectorStyle(new MonthSelectorStyleAdapter() {
      public void overrideStyle(Control control, int style) {
        switch (style) {
          // MONTHNAMELABEL is the 'style' of the label showing the current month.
          case MonthSelectorStyle.MONTHNAMELABEL:
            // set the background of the label to red. We could change fonts here
            // as well.
            control.setBackground(red);
            break;
        }
      }
    });
    // done customizing.
    

    // finally add the selection listener
    popupCal.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent e) {
        if (popupCal.getDate() != null) {
          showDate.setText(new SimpleDateFormat("EEE MM/dd/yy").format(
              popupCal.getDate().getTime()));
        }
      }
    });


    // a little trick to speed up opening the window
    popupCal.getDateChooser().paint();
    
    // set the initial focus and open the shell.
    select.setFocus();
    shell.pack();
    shell.open();

    // if at any point you were done with the popup window you would dispose it 
    // like this:
    // popupCal.dispose();  // same as popupCal.getShell().dispose();
    // red.dispose(); 
    

    // The main event loop.
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }
}

