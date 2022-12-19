import styled from 'styled-components'


const StyledHeader = styled.header`
  position: fixed;
  left: 0px;
  top: 0px;
  width: 100%;
  height: 60px;
  background-color: #002034;
`;

const StyledContent = styled.div`
  display: flex;
  width: 96%;
  max-width: 1100px;
  height: 100%;
  margin: 0 auto;
  align-items: center;
  justify-content: space-between;
  color: #e8e8e8;
`;

const StyledNav = styled.nav`
ul {
  display: flex;
  list-style: none;

  li + li {
    margin-left: 30px;
  }
}
`;


const Header = () => {
    return (
        <StyledHeader>
           <StyledContent>
            <div>Tech Recruit</div>
            <StyledNav>
              <ul>
                <li>스크랩</li>
                <li>로그인</li>
              </ul>
            </StyledNav>
           </StyledContent>
        </StyledHeader>
    )
}

export default Header;