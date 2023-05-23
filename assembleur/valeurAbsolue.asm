org 100h
jmp debut

   nb DW 5
   ValeurAbsolue DW ?
            
            
debut:

   CMP nb, 0
   JG Positif  
      MOV AX, nb
      NEG AX
      MOV ValeurAbsolue, AX
      JMP Fin
   Positif:
      MOV AX,nb
      MOV ValeurAbsolue, AX
   Fin:
   
   

ret




