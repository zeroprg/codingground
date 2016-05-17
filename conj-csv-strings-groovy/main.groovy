 /**
  * Split old value and new value add a and reagregate them into new CSV  structure like this  [ key1=old_value1;new_valuel, key1=old_value2;new_value2 ..]
  * @param old_value
  * @param new_value
  * @return
  */
 def populateNewValue( old_value , new_value ) 
 {
  def regExpr_to_split_csv = /,/
  def old_values = old_value.split(regExpr_to_split_csv);
  def new_values = new_value.split(regExpr_to_split_csv);
  println " Old value: " + old_values + " New Value: " +  new_values
  String  ret =''
  for (i=0; i<min(old_values.length,new_values.length); i++  )
  {
    println " Old value: " + old_values[i] + " New Value: " +  new_values[i]
    if(new_values[i].split('=')[0] == new_values[i].split('=')[0] )
    {
        value = (old_values[i].split('=')[1] == new_values[i].split('=')[1]) ? old_values[i].split('=')[1] : old_values[i].split('=')[1] + ';' +  new_values[i].split('=')[1] 
        ret += ((ret != '')? ',' :'') +  old_values[i].split('=')[0] + '=' +  value 
    }
  }
  ret
 }
/**
 * Find min from to primitives
 **/
 
 def min(i ,j )
 {
   i < j ? i:j
 }
 
 println populateNewValue(/T=7928,A=DI,C=TCNU5826602,W=10.6/,/T=7927,A=DI,C=CLHU8953931,W=6.7/)