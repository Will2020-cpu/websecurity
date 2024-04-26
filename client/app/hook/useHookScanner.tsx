import { useState } from "react";

export default function useHookScanner() {
  const [modal, setModal] = useState<boolean>(false);

  //add e for event the form
  function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault(); // Prevent default form submission behavior
    //active modal
    setModal(true);
  }
  return { handleSubmit, setModal, modal };
}
