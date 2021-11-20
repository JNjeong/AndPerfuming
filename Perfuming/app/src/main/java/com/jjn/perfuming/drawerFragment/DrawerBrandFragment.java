package com.jjn.perfuming.drawerFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.jjn.perfuming.R;


public class DrawerBrandFragment extends Fragment {

    /* 선언 */
    ImageButton imgbtnacquadiparma, imgbtnmercedesbenz, imgbtnbulgari, imgbtnbubery, imgbtnbyredo, imgbtncalvinklein, imgbtnchanel, imgbtnchloe, imgbtnchristiandior, imgbtnclean,
            imgbtncreed, imgbtndemeter, imgbtndiptyque, imgbtndolcegabbana, imgbtneisenberg, imgbtnforment, imgbtngiorgiormani, imgbtngucci, imgbtnjimmychoo, imgbtnjohnvarvatos, imgbtnjomalone,
            imgbtnkenzo, imgbtnkeihl, imgbtnlaferrari, imgbtnlanvin, imgbtnlelabo, imgbtnlolitalempicka, imgbtnmaisonmargiela, imgbtnmarcjacobs, imgbtnmontblanc, imgbtnnarcisorodriguez,
            imgbtnpenhaligons, imgbtnprada, imgbtnsalvatoreferragamo, imgbtntomford, imgbtnversace;
    onChangeListener changelistener;

    /* 값을 넘기는 함수 구현 */
    public interface onChangeListener{
        void onChanged(String text);
    }

    public void setOnChangeListener(onChangeListener listener){
        this.changelistener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer_brand, container, false);

        /* 연결 */
        {
            imgbtnacquadiparma = view.findViewById(R.id.imgbtnacquadiparma);
            imgbtnmercedesbenz = view.findViewById(R.id.imgbtnmercedesbenz);
            imgbtnbulgari = view.findViewById(R.id.imgbtnbulgari);
            imgbtnbubery = view.findViewById(R.id.imgbtnburbery);
            imgbtnbyredo = view.findViewById(R.id.imgbtnbyredo);
            imgbtncalvinklein = view.findViewById(R.id.imgbtncalvinklein);
            imgbtnchanel = view.findViewById(R.id.imgbtnchanel);
            imgbtnchloe = view.findViewById(R.id.imgbtnchloe);
            imgbtnchristiandior = view.findViewById(R.id.imgbtnchristiandior);
            imgbtnclean = view.findViewById(R.id.imgbtnclean);
            imgbtncreed = view.findViewById(R.id.imgbtncreed);
            imgbtndemeter = view.findViewById(R.id.imgbtndemeter);
            imgbtndiptyque = view.findViewById(R.id.imgbtndiptyque);
            imgbtndolcegabbana = view.findViewById(R.id.imgbtndolcegabbana);
            imgbtneisenberg = view.findViewById(R.id.imgbtneisenberg);
            imgbtnforment = view.findViewById(R.id.imgbtnforment);
            imgbtngucci = view.findViewById(R.id.imgbtngucci);
            imgbtnjimmychoo = view.findViewById(R.id.imgbtnjimmychoo);
            imgbtnjohnvarvatos = view.findViewById(R.id.imgbtnjohnvarvatos);
            imgbtnjomalone = view.findViewById(R.id.imgbtnjomalone);
            imgbtnkenzo = view.findViewById(R.id.imgbtnkenzo);
            imgbtnkeihl = view.findViewById(R.id.imgbtnkiehl);
            imgbtnlaferrari = view.findViewById(R.id.imgbtnlaferrari);
            imgbtnlanvin = view.findViewById(R.id.imgbtnlanvin);
            imgbtngiorgiormani = view.findViewById(R.id.imgbtngiorgioarmani);
            imgbtnlelabo = view.findViewById(R.id.imgbtnlelabo);
            imgbtnlolitalempicka = view.findViewById(R.id.imgbtnlolitalempicka);
            imgbtnmaisonmargiela = view.findViewById(R.id.imgbtnmaisonmargiela);
            imgbtnpenhaligons = view.findViewById(R.id.imgbtnpenhaligons);
            imgbtnprada = view.findViewById(R.id.imgbtnprada);
            imgbtnsalvatoreferragamo = view.findViewById(R.id.imgbtnsalvatoreferragamo);
            imgbtntomford = view.findViewById(R.id.imgbtntomford);
            imgbtnversace = view.findViewById(R.id.imgbtnversace);
            imgbtnmarcjacobs = view.findViewById(R.id.imgbtnmarcjacobs);
            imgbtnmontblanc = view.findViewById(R.id.imgbtnmontblanc);
            imgbtnnarcisorodriguez = view.findViewById(R.id.imgbtnnarcisorodriguez);
        }


        /* 구현 */
        //tablerow 1
        {
            imgbtnacquadiparma.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#acquadiparma");
                }
            });
            imgbtnmercedesbenz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#mercedesbenz");
                }
            });
            imgbtnbulgari.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#bulgari");
                }
            });
        }
        //tablerow 2
        {
            imgbtnbubery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#burbery");
                }
            });
            imgbtnbyredo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#byredo");
                }
            });
            imgbtncalvinklein.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#calvinklein");
                }
            });
        }
        //tablerow 3
        {
            imgbtnchanel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#chanel");
                }
            });
            imgbtnchloe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#chloe");
                }
            });
            imgbtnchristiandior.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#christiandior");
                }
            });
        }
        //tablerow 4
        {
            imgbtnclean.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#clean");
                }
            });
            imgbtncreed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#creed");
                }
            });
            imgbtndemeter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#demeter");
                }
            });
        }
        //tablerow 5
        {
            imgbtndiptyque.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#diptyque");
                }
            });
            imgbtndolcegabbana.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#dolcegabbana");
                }
            });
            imgbtneisenberg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#eisenberg");
                }
            });
        }
        //tablerow 6
        {
            imgbtnforment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#forment");
                }
            });
            imgbtngiorgiormani.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#giorgioarmani");
                }
            });
            imgbtngucci.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#gucci");
                }
            });
        }
        //tablerow 7
        {
            imgbtnjimmychoo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#jimmychoo");
                }
            });
            imgbtnjohnvarvatos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#johnvarvatos");
                }
            });
            imgbtnjomalone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#jomalone");
                }
            });
        }
        //tablerow 8
        {
            imgbtnkenzo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#kenzo");
                }
            });
            imgbtnkeihl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#keihl");
                }
            });
            imgbtnlaferrari.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#laferrari");
                }
            });
        }
        //tablerow 9
        {
            imgbtnlanvin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#lanvin");
                }
            });
            imgbtnlelabo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#lelabo");
                }
            });
            imgbtnlolitalempicka.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#lolitalempicka");
                }
            });
        }
        //tablerow 10
        {
            imgbtnmaisonmargiela.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#maisonmargiela");
                }
            });
            imgbtnmarcjacobs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#marcjacobs");
                }
            });
            imgbtnmontblanc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#montblanc");
                }
            });
        }
        //tablerow 11
        {
            imgbtnnarcisorodriguez.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#narcisorodriguez");
                }
            });
            imgbtnpenhaligons.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#penhaligons");
                }
            });
            imgbtnprada.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#prada");
                }
            });
        }
        //tablerow 12
        {
            imgbtnsalvatoreferragamo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#salvatoreferragamo");
                }
            });
            imgbtntomford.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#tomford");
                }
            });
            imgbtnversace.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changelistener.onChanged("#versace");
                }
            });
        }



        return view;
    }
}