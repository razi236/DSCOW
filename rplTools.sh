#!/bin/bash
echo "**************************************************************************"
echo "*          Welcome to RplTool's Descision Support for Emergency Workflow          *"
echo "**************************************************************************"
echo "How many simulations would you like to run?"
read sim
echo "How many concurrent cases would you like to run?"
read conc
echo "Please indicate your preferred resource efficiency configuration"
echo "Please select a number between 1 and 7."
read option
if [ $option = "1" ]
then
{
    cp ./examples/e1-c1.rpl temp.rpl
    YOUR_FILE='temp.rpl'
    TEXT="conc"
    sed -i "" "s/$TEXT/$conc/" $YOUR_FILE
  frontend/bin/absc -s temp.rpl
  cp RABS.abs ABS.rpl
  c=1
  frontend/bin/absc -e ABS.rpl
  while [ $c -le $sim ]
  do
      # timeout 25
      echo "Simulation " $c " with " $conc "concurrent cases started"
      echo ""
      gen/erl/run
      echo "Simulation " $c " with " $conc "concurrent cases finished"
      (( c++ ))
  done
}
# shellcheck disable=SC1073
elif [ $option = "2" ]
then
{
    cp ./examples/e1-c2.rpl temp.rpl
        YOUR_FILE='temp.rpl'
        TEXT="conc"
        sed -i "" "s/$TEXT/$conc/" $YOUR_FILE
      frontend/bin/absc -s temp.rpl
      cp RABS.abs ABS.rpl
      c=1
      frontend/bin/absc -e ABS.rpl
      while [ $c -le $sim ]
      do
          # timeout 25
          echo "Simulation " $c " with " $conc "concurrent cases started"
          gen/erl/run
          echo "Simulation " $c " with " $conc "concurrent cases finished"
          (( c++ ))
      done
}
# shellcheck disable=SC1131
elif [ $option = "3" ]
then
{
      cp ./examples/e1-c3.rpl temp.rpl
          YOUR_FILE='temp.rpl'
          TEXT="conc"
          sed -i "" "s/$TEXT/$conc/" $YOUR_FILE
        frontend/bin/absc -s temp.rpl
        cp RABS.abs ABS.rpl
        c=1
        frontend/bin/absc -e ABS.rpl
        while [ $c -le $sim ]
        do
            # timeout 25
            echo "Simulation " $c " with " $conc "concurrent cases started"
            gen/erl/run
            echo "Simulation " $c " with " $conc "concurrent cases finished"
            (( c++ ))
        done
}
elif [ $option = "4" ]
then
{
      cp ./examples/e1-c4.rpl temp.rpl
          YOUR_FILE='temp.rpl'
          TEXT="conc"
          sed -i "" "s/$TEXT/$conc/" $YOUR_FILE
        frontend/bin/absc -s temp.rpl
        cp RABS.abs ABS.rpl
        c=1
        frontend/bin/absc -e ABS.rpl
        while [ $c -le $sim ]
        do
            # timeout 25
            echo "Simulation " $c " with " $conc "concurrent cases started"
            gen/erl/run
            echo "Simulation " $c " with " $conc "concurrent cases finished"
            (( c++ ))
        done

}
elif [ $option = "5" ]
then
{
      cp ./examples/e1-c5.rpl temp.rpl
          YOUR_FILE='temp.rpl'
          TEXT="conc"
          sed -i "" "s/$TEXT/$conc/" $YOUR_FILE
        frontend/bin/absc -s temp.rpl
        cp RABS.abs ABS.rpl
        c=1
        frontend/bin/absc -e ABS.rpl
        while [ $c -le $sim ]
        do
            # timeout 25
            echo "Simulation " $c " with " $conc "concurrent cases started"
            gen/erl/run
            echo "Simulation " $c " with " $conc "concurrent cases finished"
            (( c++ ))
        done

}
elif [ $option = "6" ]
then
{
      cp ./examples/e1-c6.rpl temp.rpl
          YOUR_FILE='temp.rpl'
          TEXT="conc"
          sed -i "" "s/$TEXT/$conc/" $YOUR_FILE
        frontend/bin/absc -s temp.rpl
        cp RABS.abs ABS.rpl
        c=1
        frontend/bin/absc -e ABS.rpl
        while [ $c -le $sim ]
        do
            # timeout 25
            echo "Simulation " $c " with " $conc "concurrent cases started"
            gen/erl/run
            echo "Simulation " $c " with " $conc "concurrent cases finished"
            (( c++ ))
        done

}
elif [ $option = "7" ]
then
{
      cp ./examples/e1-c7.rpl temp.rpl
          YOUR_FILE='temp.rpl'
          TEXT="conc"
          sed -i "" "s/$TEXT/$conc/" $YOUR_FILE
        frontend/bin/absc -s temp.rpl
        cp RABS.abs ABS.rpl
        c=1
        frontend/bin/absc -e ABS.rpl
        while [ $c -le $sim ]
        do
            # timeout 25
            echo "Simulation " $c " with " $conc "concurrent cases started"
            gen/erl/run
            echo "Simulation " $c " with " $conc "concurrent cases finished"
            (( c++ ))
        done
}
else
{
    echo "Wrong selection"
}
fi

