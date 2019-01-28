package com.example.busarrival.Listener;

public class FragmentSelectedListenerImpl implements FragmentSelectedListener {
   public interface FragmentListener{
       public void selectedFragment(int i, int position);
   }

   FragmentListener mListener;

   public void setOnFragmentLister(FragmentListener listener){
       mListener = listener;
   }

    @Override
    public void onMainFragmentSelected(int position) {
        if(mListener != null){
            mListener.selectedFragment(1, position);
        }
    }

    @Override
    public void onSecondFragmentSelected(int position) {
        if(mListener != null){
            mListener.selectedFragment(2, position);
        }
    }
}
