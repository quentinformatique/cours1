org 100h

jmp debut
   Tmot DW 1 DUP (1, 2, 3, 4, 5, 6, 7, 8, 9)
   Tfin DB 1 DUP(?)
   
debut:

   MOV BX, offset Tmot
   MOV BP, offset Tfin
   
   MOV SI, 0
   MOV DI, 0
   MOV CX, 9
   
   boucle:
      MOV AX, [BX][SI]
      ADD AX, 48
      MOV [BP][DI], AX
      ADD SI, 2
      ADD DI, 1
      LOOP boucle
      
ret
