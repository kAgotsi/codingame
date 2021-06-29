# How to contribute to the app

 1. [**Opening an issue**](#opening-an-issue)
    - [Adding a new feature or changing an existing one](#adding-a-new-feature-or-changing-an-existing-one)
    - [Did you find a bug?](#did-you-find-a-bug)
 1. [**Working on a branch**](#working-on-a-branch)
 1. [**Coding rules**](#coding-rules)
    - [Coding conventions](#coding-conventions)
    - [Commit message guidelines](#commit-message-guidelines)

## Opening an issue
### Adding a new feature or changing an existing one

* Talk to the other members about your project
* Open an issue. Describe your intention as clearly as possible, what are the objectives and what you want to achieve.

### Did you find a bug?

* **Ensure the bug was not already reported** by searching on GitLab under [Issues](https://github.com/kAgotsi/codingame/issues).

* If you're unable to find an open issue addressing the problem, open a new one. Be sure to include a **title and clear description**, as much relevant information as possible, clearly describe the **steps necessary to reproduce the issue** you are running into and **screenshot** pr a **code sample** or an **executable test case** demonstrating the expected behavior that is not occurring. Then, it is time to [create a new branch](#working-on-a-branch).


## Working on a branch

_After opening an issue_
- Go to your project
- Pull, create and checkout on your local branch 
- Code
- Add, commit, push...
- Create Merge request
- Link the issue to the Merge request
- Ready for Merge request, remember to check the checkbox to delete the source branch after merge.

## Coding rules

### Coding conventions
We optimize for readability:
- We respect spring boot java coding conventions


### Commit message guidelines

Consider starting the commit message with the **type of the commit** then add a clear and brief **description** of what you did.
`git commit -m "Add a description"`

#### Type of the commit
Must be one of the following:
* `build`: when that affect the build system or external dependencies (npm, make…)
* `ci`: when concerning the integration and configuration files and scripts (Travis, Ansible, BrowserStack ...)
* `feat`: when introduing new features
* `fix`: when fixing a bug
* `perf`: when improving performance
* `refactor`: when refactoring code
* `style`: when improving structure / format of the code, changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc)
* `docs`: when writing or updating documentation
* `test`: when adding or modifying tests

#### Description
The subject contains succinct description of the change:
* use present tense: "change" not "changed" nor "changes"
* capitalize first letter
* no dot (.) at the end
