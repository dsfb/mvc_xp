




class Mvp5217611 {
 
  public static void main(String[] args){
        View view = new YourImplementationOfView();
        Model model = new MyImplementationOfModel();

        //create jframe
        //frame.add(view.getUI());
 
        //make sure the view and model is fully initialized before letting the controller control them.
        Controller controller = new MyImplementationOfController(view, model);

        //frame.setVisible(true);
     }
  
}

interface View{
    JTextField getTxtFirstName();
    JTextField getTxtLastName();
    JTextField getTxtAddress();
}

public class MyImplementationOfModel implements Model{
    private SwingPropertyChangeSupport propChangeFirer;
    private String address;
    private String firstName;
    private String lastName;

    public MyImplementationOfModel() {
        propChangeFirer = new SwingPropertyChangeSupport(this);
    }
    public void addListener(PropertyChangeListener prop) {
        propChangeFirer.addPropertyChangeListener(prop);
    }
    public void setAddress(String address){
        String oldVal = this.address;
        this.address = address;

        //after executing this, the controller will be notified that the new address has been set. Its then the controller's
        //task to decide what to do when the address in the model has changed. Ideally, the controller will update the view about this
        propChangeFirer.firePropertyChange("address", oldVal, address);
    }
    
    //some other setters for other properties & code for database interaction
    
}

public class MyImplementationOfController implements PropertyChangeListener, Controller{

    private View view;
    private Model model;

    public MyImplementationOfController(View view, Model model){
        this.view = view;
        this.model = model;

        //register the controller as the listener of the model
        this.model.addListener(this);

        setUpViewEvents();
    }

    //code for setting the actions to be performed when the user interacts to the view.
    private void setUpViewEvents(){
        view.getBtnClear().setAction(new AbstractAction("Clear") { 
            @Override
            public void actionPerformed(ActionEvent arg0) {
                model.setFirstName("");
                model.setLastName("");
                model.setAddress("");
            }
        });

        view.getBtnSave().setAction(new AbstractAction("Save") { 
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //validate etc.
                model.setFirstName(view.getTxtFName().getText());
                model.setLastName(view.getTxtLName().getText());
                model.setAddress(view.getTxtAddress().getText());
                model.save();
            }
        });
    }

    public void propertyChange(PropertyChangeEvent evt){
        String propName = evt.getPropertyName();
        Object newVal = evt.getNewValue();

        if("address".equalsIgnoreCase(propName)){
            view.getTxtAddress().setText((String)newVal);
        }
        //else  if property (name) that fired the change event is first name property
        //else  if property (name) that fired the change event is last name property
    }
}
