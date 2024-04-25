import type { MetaFunction } from "@remix-run/node";
import logo from '/website-scanner.svg';

export const meta: MetaFunction = () => {
  return [
    { title: "New Remix App" },
    { name: "description", content: "Welcome to Remix!" },
  ];
};

export default function Index() {
  return (
    <div className="h-screen w-screen p-60">
      <div className="flex justify-between content-center w-full h-full">
        <div className="">
          <img src={logo} alt="logo" className="w-24 h-24 shadow-black shadow-2xl rounded-lg border-noned drop-shadow-lg" />
          <h1 className="text-2xl font-bold">Website Vulnerability Scanner</h1>
        </div>
        <div className="bg-white rounded-lg p-8 shadow-2xl drop-shadow-lg w-1/3 ">
          <form className=" mx-auto">
            <label htmlFor="email"  className="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Your email</label>
            <input type="email" id="email" aria-describedby="helper-text-explanation" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="name@flowbite.com"/>
            <input type="button" className="color mt-2 text-sky-900 p-2 rounded-lg text-sm w-full" value="Escanear"/>
          </form>
        </div>
      </div>
    </div>
  );
}
