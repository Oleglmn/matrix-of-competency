package com.example.classes;

public class NestedInterfaceExample implements Events.View{
    public static void main(String[] args) {
        System.out.println("\n\n***********Anonymous Class Implementing Nested Interface*************");
        Events events = new Events();
        //Below is your anonymous class implementing an interface.
        events.setOnClickListener(new Events.View.onClickListener() {
            //Receiving Click Listener
            @Override
            public void onClick() {
                System.out.println("Event Clicked!!");
            }
        });
        events.setOnFocusListener(new Events.View.onFocusChangeListener() {
            //Receiving Click Listener
            @Override
            public void onFocus() {
                System.out.println("Event is being Focused!!");
            }
        });
        events.setClicked();
        events.setFocused();
    }
}

class Events {

    private View.onClickListener clickListener;
    private View.onFocusChangeListener focusChangeListener;

    public void setOnClickListener(View.onClickListener listener){
        clickListener = listener;
    }

    public void setClicked(){
        if(clickListener!=null) {
            clickListener.onClick();
        }
    }

    public void setOnFocusListener(View.onFocusChangeListener listener){
        focusChangeListener = listener;
    }

    public void setFocused(){
        if(focusChangeListener!=null) {
            focusChangeListener.onFocus();
        }
    }

    interface View {

        //Nested Interfaces
        interface onClickListener{
            void onClick();
        }
        interface onFocusChangeListener{
            void onFocus();
        }
    }
}
