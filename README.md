# Atos codingame challenge 

[![CodeFactor](https://www.codefactor.io/repository/github/ajarno/to52-project/badge/develop?s=53b7342f68a10c0e24ef9e9d6e7587e072f5abcc)](https://www.codefactor.io/repository/github/ajarno/to52-project/overview/develop)

1. [**Presentation**](#presentation)
1. [**start by coding**](#sarting-by-coding)
1. [**Clone application**](#clone-application)

## Presentation

Create 2 REST services: one that allows to register a user and the other one that displays the details
of a registered user.
Requirements:
- define a user (what are the fields needed). We should have mandatory and optional fields!
- validate the input and return proper error messages/http status
- log the input and output of each call and the processing time.
- have a request parameter which is not mandatory and which provides a default value in case is not
set
- have a path variable
- clear code and javadoc
- unit tests
- only adults ( age &gt; 18 years)  and that live in France can create an account!

Bonuses:
- user a non-relational DB in order to save the users!
- use AOP
- documentation/UML/schemas to explain the architecture

## Starting by coding

Avant de commencer à coder, veuillez lire le [CONTRIBUTING.md](./CONTRIBUTING.md) qui indique toutes les bonnes pratiques et les conventions que nous utilisons.

### CLone application

Once the tools have been installed and the environment prepared, download the application code:
`git clone https://github.com/ajarno/TO52-Project.git`
