# Réseaux

[...]

## III - NFS

Partage de fichier sur Linux.

C'est une application client serveur, relativement ancienne.
Construite sur la base de l'intergiciel RPC (Remote Procedure Call).
**RPC** est à la fois:

- est une librairie pour la création d'application client serveur
- gére les échanges entre client et serveur
- offre un "aiguilleur" permettant à tout logiciel écrit avec RPC d'être identifié à distance

**NFS** reprend les fonctions classiques de gestion de système de fichiers (cd, ls, mkdir, rm, mv, ...)

L'aiguilleur est exécuté sur le serveur RPC (donc sur le serveur NFS).
Il référence tous les programmes serveur disponibles, construits avec RPC (NFS ou autre), par une adresse (en réalité, adresse IP du serveur et numéro de port).\
Les clients ne connaissent pas ces adresses. Par contre, ils savent (par construction) contacter l'aiguilleur.
Lorsqu'un client souhaite utiliser un programme distant RPC, il demande à l'aiguilleur l'adresse correspondant au programme demandé. Puis le client contacte directement le programme serveur.

Exemple avec NFS:

- Un utilisateur saisit `ls dossier_partage`
- L'OS reconnait qu'il s'agit d'un dossier partagé et donc utilise le client NFS (C) au lieu de lancer la commande système `ls`
- C interroge l'aiguilleur (S) correspondant à ce dossier partagé (paramétrage de C) pour obtenir l'adresse
- C contacte le programme serveur (S) et lui demande d'exécuter la commande `ls dossier_partage`
- S exécute la commande et retourne le résultat à C
- C affiche le résultat à l'utilisateur

Autres programmes (noms de service RPC) inclus avec NFS aussi bien côté S que C

- `mountd` : équivalent de `mount` à distance -> permet de monter un système dossier distant dans un local
- `nlockmgr` : permet de verrouiller les fichiers/dossiers lorsqu'ils sont utilisés
- `status` : permet de contrôler les accès aux partages

## IV - Partage d'imprimante

Windows : avec **SMB**, comme pour un partage de dossier
Tout système : **LPD/LPR** (Line Printer Daemon/Line Printer Remote; RFC 1179), HP JetDirect, IPP (Internet Printing Protocol ; RFC 2567)
Caractéristiques communes de ces applications :

- C / S
- Le serveur est sur la machine ayant l'imprimante reliée (ou directement sur l'imprimante si elle est autonome = imprimante réseau)
- Le client est sur toutes les autres machines
- Échange de quelques commandes : annulation, reprise, ...
- Envoie de données prêtes à être imprimées (dans un langage directement compris par l'imprimante comme PostScript) -> obligation d'avoir un pilote d'imprimante sur le client.

**IPP**, plus récent et plus complet, est une "extension" de HTTP (Web) dédiée, ce qui permet une configuration (coté serveur) ou un suivi (coté client) via un navigateur Web.

## V - Télémaintenace et gestion de parc informatique

**Télémaintenance** = accès à distance à un ordinateur pour le contrôler, le surveiller, le dépanner, ...\
But : gérer, dépanner (au moins diagnostiquer) une machine à distance
Repose sur des applications C / S qui transmettent :

- les actions clavier / souris du dépanneur vers la machine dépannée; celle-ci les éxécutent localement.
- Le contenu de l'écran de la machine dépannée vers celle du dépanneur (sous forme d'images à un rythme et une qualité fonction des débits réseaux disponibles)
- Parfois aussi des fichiers, du son, ...

2 types : avec ou sans intermédiaire

- Sans intermédiaire\
   C (appelé "viewer") installé / éxécuté sur la machine controlante, S sur la machine controlée\
   _Ex : RDP, SSH, VNC (TightVNC), ..._

- Avec intermédiaire \
   C sur la machine controlée et la machine controlante, S (chez un prestataire) fait le lien entre les 2\
   _Ex : TeamViewer, BeyondTrust, Google Chrome Remote Desktop, ..._

Avantages / Inconvénients des applications avec intermédaire /sans intermédaire

- \+ Facilité de la configuration même si les 2 machines ne sont pas sur le même réseau
- \- Rarement gratuit
- \- Sécurité non maitrisée : protocole non connu, transfert via prestataire, ...

### RDP

**RDP** = Remote Desktop Protocol (propriété Microsoft)
Solution uilsée "Bureau à distance" (S) et "Connexion bureau à distance" (C)
C identifie S par son adresse IP et son nom
Accès limité par authentification avec un compte de S (ou certificat)
Chiffrement des échanges.

### SSH

**SSH** = Secure Shell (RFC 4251)\
Protocole utilisé sur Linux & co\
Logiciel en mode console; déport graphique en option (X11)\
Logiciel créé par une société privée; OpenSSH est une version libre habituellement utilisée (client=ssh, serveur=sshd)\
C identifie S par son adresse IP et son nom\
Accès limité par authentification avec un compte de S (ou certificat) `ssh[option] compte@machine_distante`.
Chiffrement des échanges.
Transfert de fichiers avec commande spécifique scp = ssh + cp

### VNC

**VNC** = Virtual Network Computing.\
Utilise le protocole RFB (Remote Frame Buffer) (RFC 6143)

Particularités:

- Authentification simple et non obligatoire
- Transmissions sans chiffrage (en clair)
- Affichage transmis rectangle par rectangle (avec plus ou moins d'encodage), à la demande de C -> si C et/ou le réseau est lent, image incohérente au niveau de C

### Parc informatique

Parc informatique = ensemble de machines et de logiciels d'une structure (machines, infrastructure réseau, périphériques, O.S., logiciels, ...)\
Le gestion d'un parc informatique (=ITSM = Information Technology Service Management) consiste en :

- Inventaire du parc
- Maintenance du parc : détection / répartition /suivi des problèmes, mise à jour des logiciels, changement des matériels / logiciels obsolètes, ...

Applications dédiées fonctionnent en C/S pour faciliter le travail, centraliser les infos, ...\
_Exemple: OpenMMS, OCS Inventory (client), FusionInventory (client), GLPI (serveur), iTop (serveur), Net-SNMP (client et serveur), IBM NetView (serveur), HP IMC (serveur), ..._\

Particulartités de ces applications :

- Client automatique, sans IHM; IHM sur le serveur (pour les administrateurs)
- Ces applications utilisent soit un protocole propriétaire et / ou SNMP \
**SNMP** = Simple Network Management Protocol (RFC 3410 pour la v3)

### SNMP

Chaque machine du LAN est appelée noeud administré\
Pour tout type de machine : ordinateur, périphériques (imprimantes, etc), matériel d'infrastructure réseau (switch, routeur, ...)

Client agent SNMP. Installé sur chaque noeud administré.\
But : recueillir un ensemble de données décrivant la machine + éventuellement agir sur elle suivant ordres donnés par le serveur

Serveur = **NMS** (Network Management System). Sous contrôle de l'administration du LAN.\
But : récupérer et centraliser les données de chaque machine, permettre d'agir à distance sur certains paramètres de la machine (par exemple : arrêter l'interface réseau ou la machine)

Chaque type de données est répertorié au niveau mondial par un **OID** (Object ID) inclus dans un unique arbre.

Sur chaque machine, un (ou plusieurs) fichier(s) MIB (Management Information Base) décrit les OID que le client SNMP doit récupéré sur son noeud.\
Sur ordinateur, MIB à installer. Sur les autres machines, MIB pré-installé (si machine compatble avec SNMP)

Parmi les OID :

- Certains sont "universel" et normalisés. Ceux liés au réseau : interface réseau, IP, ...
- D'autres sont spécifiques et non normalisés. Ceux liés aux matériels (imprimante, routeur, ...) ou aux logiciels -> dans la branche "private" de l'arbre, chaque marque doit se créer un sous arbre pour être compatible SNMP.

2 modes de fonctionnement des agents SNMP :

- Mode normal : l'agent renvoie au serveur la valeur des OID demandés
- Mode trap (="alerte") : lorsque l'agent constate un changement jugé important sur sa machine (panne d'un élément par ex.), il envoie la nouvelle valeur de l'OID au serveur sans que celui-ci n'en ai fait la demande -> plus conforme au modèle C/S

## DHCP

**DHCP** (Dynamic Host Configuration Protocol) RFC 2131\
Application C / S qui permet de configurer automatiquement les paramètres IP de chaque machine du LAN\
Toutes les machines ont un client DHCP\
À installer / configurer : un (unique) serveur DHCP dans le LAN\
Mais, par défaut, déjà pré-installé et pré-configuré sur les box, bornes WiFi, ...

Un bail contient une adresse IP, un masque, une durée de validité + diverses options dont l'adresse IP de la passerelle, ...\
L'adresse IP est choisie par S "au hasard" dans une plage d'adresse prédéfinies (appelé "étendue").\
Il est possible de fixer au niveau de S un bail en fonction de l'adresse MAC de la machine C = réservation _(cas à l'IUT)_\
Note 1 : 2 "messages" en unicast -> C et S doivent être dans le même (sous-)réseau du point de vue IP\
Note 2 : 2 "messages" en broadcast -> C et S ne doivent pas être séparé par un routeur.

## VII - Courrier électronique

Utilise plusieurs applications indépendantes :

- **SMTP** (Simple Mail Transport Protocol) : seulement pour envoyer des méls ( RFC 821, 822 et 2822)
- **POP3** (Post Office Protocol v3) ou **IMAP4** (Internet Message Access Protocol v4) : seulement pour récupérer / lire des méls (RFC 1939 pour POP3; RFC 3501 pour IMAP4)

Architecture : cf. schéma diapo suivante

Remarque : dans ce schéma, les flèches indiquent le sens de parcours de mél, pas des échanges (bidirectionnels et nombreux)

**MUA** (Mail User Agent) = client de messagerie; logiciel intégrant tous les clients pour mél : SMTP, POP3, IMAP4, ...\
_Ex : Thunderbird, Outlook, Mail (Apple), ..._

**MTA** (Mail Transport Agent) : logiciel chargé de transférer les méls du MUA jusqu'à la "boite aux lettres (b.a.l)" du destinataire; serveur et client SMTP.\
**MDA** (Mail Delivery Agent) : logiciel chargé de transférer les méls de la b.a.l pour les envoyer au MUA du destnataire. Serveur POP3, IMAP4; en général, sur la même machine que MTA.\
_Ex: Postfix (MTA), Dovecot (MDA), Sendmail (MTA), IMB Lotus Domino (MTA/MDA), Microsoft Exchange (MTA/MDA), ..._

Comparaison MUA / Webmail:

- **Webmail** : consultation via un navigateur Web, pas d'outils spécial (+); consultation boite par boite (-); connexion internet indispensable (-)
- **MUA** : outils dédiés (+); centralisation de toutes ces boîtes (+) consultation / stockage hors ligne (+);

Comparaison POP3 / IMAP4:

- **POP3** : récupération des méls par téléchargement uniquement;pas de synchronisation (si utilisation de plusieurs MUA)
- **IMAP4** : récupération des mél par téléchargement ou "à distance"; si mode "à distance" synchronisation boîte / MUA

Format d'un mél (défini avec SMTP pour des raisons historiques + RFC 5322) :

- en-tête
- ligne blanche comme séparateur
- corps du message

**En-tête** : succesion de lignes de textes; certaines lignes sont ajoutées et / ou modifiées par les MTA/MDA.

**Corps du message** : le mél en lui-même; uniquement constitué de caractères ASCII 7-bit.

Ligne en-tête| Signification  
 --- | ---
 From : ...  |@ mél expéditeur apparente
To: ... / Cc: ... / Bcc: ... | @ mél du (des) destinataire(s) apparente(s) / copie(s) / copie(s) cachée(s)
Date: ... | date et heure d'envoi du mél (MUA)
Return-Path: ... | @ mél de retour automatique en cas de problème (destinataire inconnu par ex.) = "Form:" en générale
[...] | [...]
Received: from [S1] by [S2] | Parcours du mél (de S1 vers S2)
Message-ID: ... | identifiant unique de message construit à partir de la date, de l'adresse + une partie aléatoire
X-... | En-tête non normalisées; dépend des MTA/MDA et MUA

Format d'une adresse mél :

      utilisateur @ nom de zone DNS
ou

      utilisateur @ serveur SMTP (de + en + rare)

Le 1er format implique que **DNS** connait le nom DNS complet (et l'@ IP) du serveur SMPT qu gére tous les utilisateurs de la zone. Entrée spéciale "MX" dans les tables DNS.

Pour le 2nd format : serveur SMTP représenté par son nom DNS complet ou son adresse IP.

**Utilisateur** = "propriétaire" d'une file de réception (b.a.l) i.e un fichier ou un dossier => en général, l'utilisateur doit être connu du système serveur.

Avantage 1er format par rapport au 2nd format : on peut changer de machine ou simplement son nom sans devoir prévenir "la Terre entière" du changement.

Inconvénient 1er format par rapport au 2nd format : DNS devient indispensable.

**Liste de diffusion** : adresse pour envoyer un mél à plusieurs destinataires ("abonnés") en même temps.\
**Économie de temps et de réseau** : 1 seul exemplaire du mél sur tout ( liste MDA ) ou partie (liste  MTA exp. ou MTA dest.) du parcours du mél.\
Adresse convertie par MTA / MDA avant mise dans les b.a.l.\
2 types de listes correspondant à deux types de gestion :

- directement par MTA / MDA => gestion  que par des administrateurs du MTA / MDA
- par un logiciel dédié (Majordomo,Sympa,etc...) associé au MTA /MDA => gestion par modérateur/ créateur via le Web; utilisé par les services en ligne (Google groups,etc...).

La limitation du code ASCII 7 bits a posé problème pour de nombreuses applications et en 1er pour le courrier électronique => MIME est apparu comme une "extension" de SMTP, puis utilisé par d'autres applications (Web, SIP, ...) et systèmes.

MIME = Multipurpose Internet Mail Extensions (RFC 2045-2049)

Compatible avec toutes les applications ayant une en-tete constituée de ligne de caratéres

Le but est de décrire le format réel des données et de transcrire tout type de données en caractère ASCII compatible avec l'application.

En-tête MIME constituée principalement des lignes suivantes :

- MIME-Version: 1.0 (malgré les mises à jour)
- Content-Disposition ; contenu présenté avec le reste ou non
- Content-Length : taille du corps (en octets)
- Content-Id : identifiant du contenu
- Content-Transfer-Encoding : type d'encodage utilisé paour transformer les données en ASCII (base 64, quoted-printable, 8bit, ...)
- Content-Type : représenté sous le forme 'type/sous-type", indique le format du contenu avant encodage
  Exemple :

Type|Sous-Type|Description
---|---|---
text|plain ou html|texte ASCII ou HTML
image|gif ou jpeg|image GIF ou JPEG
Application|pdf|document PDF
Application|octet-stream|fichier binaire
Message|partial|contenu partiel (suite d'un autre renvoie)
Message|external-body|contenu à récupérer à l'adresse indiqué dans le corps

Avec SMTP, POP3 et IMAP4, tous les échanges sont en clair. Y compris les éléments d'authentification et les mél eux-mêmes

Comme pour beaucoup d'autres protocoles (dont HTTP), il existes des versions sécurisées de SMTPS, POP3S et IMAPS.

Les protocoles ne changent pas mais ajout d'une surcouche de sécurisation appelée TLS (Tranport Layer Security) - anciennement SSL (Secure Sockets Layer).

Cette surcouhe permet d'authentifier le serveur (le client s'authentifie par compte / mdp) et de chiffrer tous les échanges.

Cette surcouche est appelé soit directement en utilisant un numéro de port dédié (ex: 443 pour HTTPS au lieu de 80 pour HTTP)soit en utilisant une commande spécifique : STARTLS

## VIII - Annuaire

LDAP = Lightweight Directory Access Protocol (RFC 4510-4519)

Application C/S

Objectif: centraliser au niveau d'un serveur l'identification des "objetc" réseaux et l'authentification des utilisateurs

Objets : machine, partage, etc (+ compte considéré aussi comme des objets)

Facilite le gestion des utilisateurs et de leurs doirts d'accès aux ressources (objets) disponible dans le LAN : tout est référencé et géré au niveau du serveur LDAP

LDAP : protocole qui permet aux clients (amchines) d'interagir avec le serveur; par ex: reconnaissance d'un utilisateur, obtention des autorisations d'accès à une imprimante, etc...

Compte global : compte référencé au niveau d'un serveur LDAP => a accès (s'il a les droit) à tous les objets gérés par le serveur\
Compte local compte référencé au niveau d'une machine quelconque => n'a accés qu'à cette machine et ses ressources\
OpenLDAP : Linux\
Active Directory : variante Microsoft\
Logiciel serveur disponible uniquement sur les serveur Windows Server\
Logiciel client : tout Windows\
Domaine Active Directory = ensemble des objet et des utilisateurs sous sontôle d'un serveur appelé ici controleur de domaine.
