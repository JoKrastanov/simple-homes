context('Property', () => {
    beforeEach(() => {
      cy.visit('http://localhost:3000');
      cy.get('.NavBar-items-right').contains('Log In').click();
      cy.get('#email').type('test@gmail.com');
      cy.get('#password').type('test');
      cy.get('button').click();
      cy.wait(500);
    })

    it('cy.go() - View property', () => {
        cy.get('.NavBar-items').contains('Properties').click();
        cy.get('.properties-containers').contains("Heezerweg 150").click();
        cy.location('pathname').should('include', 'Property/1');
    })

    it('cy.go() - Search property location', () => {
        cy.get('.NavBar-items').contains('Home').click();
        cy.get('#header-search').type("Heezerweg");
        cy.get('.properties-containers').contains("Heezerweg 150").click();
        cy.location('pathname').should('include', 'Property/1');
    })

})