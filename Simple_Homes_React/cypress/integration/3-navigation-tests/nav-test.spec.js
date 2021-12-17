context('Navigation', () => {
    beforeEach(() => {
      cy.visit('http://localhost:3000');
    })

    it('cy.go() - go to Home page', () => {

        cy.get('.NavBar-items').contains('Home').click();
        cy.location('pathname').should('include', '')
    })

    it('cy.go() - go to Properties page', () => {

        cy.get('.NavBar-items').contains('Properties').click();
        cy.location('pathname').should('include', 'Properties')
    })

    it('cy.go() - go to Upload page', () => {

        cy.get('.NavBar-items').contains('Upload a property').click();
        cy.location('pathname').should('include', 'Upload')
    })

    it('cy.go() go to LogIn page', () => {
        cy.get('.NavBar-items-right').contains('Log In').click();
        cy.location('pathname').should('include', 'LogIn')
    })

    it('cy.go() go to Register page', () => {
        cy.get('.NavBar-items-right').contains('Register').click();
        cy.location('pathname').should('include', 'Register')
    })

    it('cy.go() Log In and go to Profile page', () => {
        cy.get('.NavBar-items-right').contains('Log In').click();
        cy.get('#email').type('test@gmail.com');
        cy.get('#password').type('test');
        cy.get('button').click();
        cy.location('pathname').should('include', 'Profile');
    })

    it('cy.go() go to Property page', () => {
        cy.visit('http://localhost:3000/Properties');

        cy.get('.property-container').contains('Heezerweg 150').click();
        cy.location('pathname').should('include', 'Property/1')
    })
})
