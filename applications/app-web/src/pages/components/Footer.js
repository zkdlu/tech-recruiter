import styled from 'styled-components'


const StyledFooter = styled.footer`
  height: 40px;
  margin-top: auto;
  background-color: #002034;
`;

const StyledDiv = styled.div`
  display: flex;
  height: 100%;
  margin: 0 auto;
  align-items: center;
  justify-content: center;
`;

const StyledContent = styled.span`
  font-weight: 600;
  font-size: 12px;
  color: #e8e8e8;
  a {
    text-decoration: none;
    color: inherit;
  }
`;

const Footer = () => {
    return (
        <StyledFooter>
          <StyledDiv>
            <StyledContent>
              Developer. <a target="_blank" href="https://github.com/zkdlu">이건(zkdlu)</a> 2022.
            </StyledContent>
          </StyledDiv>
        </StyledFooter>
    )
}

export default Footer;