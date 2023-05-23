ORG 100h

JMP debut 

   nb DW 7
   resultat DW 1
   

debut:

   MOV CX, nb
   
   boucle:
      MOV AX, CX
      
      MUL resultat
      
      MOV resultat, AX
      
      LOOP boucle 

ret




