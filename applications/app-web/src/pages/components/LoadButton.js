import styled from 'styled-components'

function LoadButton({ disabled, children, onClick }) {
  return <StyledButton onClick={onClick} disabled={disabled}>{children}</StyledButton>;
}

const StyledButton = styled.button`
  margin: 0;
  border: none;
  cursor: pointer;
  font-family: "Noto Sans KR", sans-serif;
  font-size: 1.25rem;
  padding: 16px 20px;
  border-radius: 12px;
  background: #28a745;
  color: #ffffff;
  align-items: center;

  &:active {
    background: #218838;
  }
  &:hover {
    background: #FF8838;
  }
`;

export default LoadButton;