
nbLines = 10000

pathBigFile = f"F:\meteo-france-donneesq-covid19.csv"
pathSmallFile = f"F:\smallFiles"

bigFile = open(pathBigFile,"r")
lines = bigFile.readlines()
nbWrote = 0
numFic = 0

for line in lines:
    
    if(nbWrote >=nbLines):
        print('chg fichie')
        nbWrote = 0
        numFic = numFic + 1
		
    with open(  pathSmallFile + str(numFic) +'.csv', 'a', encoding="utf-8") as f:
        f.write(line)

    nbWrote = nbWrote + 1