import styled from 'styled-components'

const StyledBanner = styled.div`
  width: 100%;  
  height: 18rem;
  background-image: url(/banner.png);
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;

  display: flex;
  flex-direction: column;
  justify-content: center;
`;

const StyledContent = styled.h1`
  font-size: 3.8rem;
  text-align: center;
  color: #fff;
`;

const MainBanner = () => {
    return (
      <StyledBanner>
        <StyledContent>
          Tech Recuit 
        </StyledContent>
      </StyledBanner>
    )
}

export default MainBanner;