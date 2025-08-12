import React from "react";

interface InvoiceDetailsProps {
  modelDetails: {
    modelId: string;
    modelName: string;
    price: number;
    imgPath?: string;
    manufacturer?: { mfgName: string };
    segment?: { segName: string };
  };
  selectedConfigurableOptions: Record<
    string,
    {
      altId: string;
      compId: number | string;
      compName: string;
      compType: string;
      priceImpact: number;
    }
  >;
  vehicleDetails: {
    configId: string;
    compId: number | string;
    compName: string;
    compType: string;
    isConfig: string;
  }[];
  allComponents: Record<string, string>;
  calculatedTotalPrice: number;
  quantity: number;
  taxAmount: number;
  invoiceMessage: string | null;
  setCurrentView: (view: "details" | "configure" | "invoice") => void;
  user?: {
    username?: string;
    email?: string;
  };
  invoiceId?: number | null;
  handleEmailInvoice: () => Promise<void>;
}

const InvoiceDetails: React.FC<InvoiceDetailsProps> = ({
  modelDetails,
  selectedConfigurableOptions,
  vehicleDetails,
  allComponents,
  calculatedTotalPrice,
  quantity,
  taxAmount,
  invoiceMessage,
  setCurrentView,
  user,
  invoiceId,
  handleEmailInvoice,
}) => {
  return (
    <div className="p-8 bg-gray-50 rounded-xl shadow-inner">
      <div className="max-w-4xl mx-auto bg-white p-8 rounded-lg shadow-lg">
        {/* Header */}
        <div className="border-b-2 border-gray-300 pb-6 mb-6">
          <h1 className="text-4xl font-bold text-gray-900 mb-2">INVOICE</h1>
          <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
            <div>
              <p className="text-gray-600 mb-1">
                <strong>Date:</strong> {new Date().toLocaleDateString()}
              </p>
              <p className="text-gray-600 mb-1">
                <strong>Customer:</strong> {user?.username || "Online Customer"}
              </p>
              <p className="text-gray-600 mb-1">
                <strong>Email:</strong> {user?.email || "Not Provided"}
              </p>
            </div>
            <div className="text-right">
              {invoiceId !== null && invoiceId !== undefined && (
                <p className="text-gray-600 mb-1">
                  <strong>Invoice ID:</strong> {invoiceId}
                </p>
              )}
            </div>
          </div>
        </div>

        {/* Vehicle Details */}
        <div className="mb-8">
          <h2 className="text-2xl font-semibold text-gray-800 mb-4 border-b border-gray-200 pb-2">
            Vehicle Details
          </h2>
          <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
            <div className="space-y-2">
              <p className="text-lg">
                <strong>Model:</strong> {modelDetails.modelName}
              </p>
              <p className="text-gray-700">
                <strong>Manufacturer:</strong>{" "}
                {modelDetails.manufacturer?.mfgName}
              </p>
              <p className="text-gray-700">
                <strong>Segment:</strong> {modelDetails.segment?.segName}
              </p>
              <p className="text-gray-700">
                <strong>Base Price:</strong> $
                {modelDetails.price.toLocaleString()}
              </p>
              <p className="text-gray-700">
                <strong>Quantity:</strong> {quantity}
              </p>
            </div>
            {modelDetails.imgPath && (
              <img
                src={"https://localhost:7027" + modelDetails.imgPath}
                alt={modelDetails.modelName}
                className="w-48 h-32 object-cover rounded-lg shadow-md"
                onError={(e) => {
                  e.currentTarget.src =
                    "https://placehold.co/300x200/cccccc/333333?text=No+Image";
                }}
              />
            )}
          </div>
        </div>

        {/* Selected Components */}
        <div className="mb-8">
          <h2 className="text-2xl font-semibold text-gray-800 mb-4 border-b border-gray-200 pb-2">
            Selected Components
          </h2>
          {Object.values(selectedConfigurableOptions).length ? (
            <div className="overflow-x-auto">
              <table className="w-full border-collapse border border-gray-300">
                <thead>
                  <tr className="bg-gray-100">
                    <th className="border px-4 py-3 text-left font-semibold">
                      Type
                    </th>
                    <th className="border px-4 py-3 text-left font-semibold">
                      Name
                    </th>
                    <th className="border px-4 py-3 text-left font-semibold">
                      Selection
                    </th>
                    <th className="border px-4 py-3 text-right font-semibold">
                      Impact
                    </th>
                  </tr>
                </thead>
                <tbody>
                  {Object.values(selectedConfigurableOptions).map((opt, i) => (
                    <tr
                      key={opt.altId}
                      className={i % 2 === 0 ? "bg-white" : "bg-gray-50"}
                    >
                      <td className="border px-4 py-3">{opt.compType}</td>
                      <td className="border px-4 py-3">{opt.compName}</td>
                      <td className="border px-4 py-3">
                        <span
                          className={`inline-block px-2 py-1 rounded-full text-xs font-medium ${
                            opt.altId.startsWith("default")
                              ? "bg-blue-100 text-blue-800"
                              : "bg-green-100 text-green-800"
                          }`}
                        >
                          {opt.altId.startsWith("default")
                            ? "Default"
                            : "Alternate"}
                        </span>
                      </td>
                      <td className="border px-4 py-3 text-right">
                        <span
                          className={
                            opt.priceImpact >= 0
                              ? "text-green-600 font-semibold"
                              : "text-red-600 font-semibold"
                          }
                        >
                          {opt.priceImpact >= 0 ? "+" : ""}$
                          {Math.abs(opt.priceImpact).toLocaleString()}
                        </span>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          ) : (
            <p className="text-center text-gray-500">
              No components configured; using defaults.
            </p>
          )}
        </div>

        {/* Price Breakdown */}
        <div className="bg-gray-50 p-6 rounded-lg mb-8">
          <h2 className="text-2xl font-semibold text-gray-800 mb-4">
            Price Breakdown
          </h2>
          <div className="space-y-3">
            <div className="flex justify-between">
              <span>Unit Price:</span>
              <span>${calculatedTotalPrice.toLocaleString()}</span>
            </div>
            <div className="flex justify-between">
              <span>Tax (18%):</span>
              <span>${taxAmount.toLocaleString()}</span>
            </div>
            <div className="flex justify-between font-semibold">
              <span>Price + Tax:</span>
              <span>
                ${(calculatedTotalPrice + taxAmount).toLocaleString()}
              </span>
            </div>
            <div className="flex justify-between">
              <span>Quantity:</span>
              <span>{quantity}</span>
            </div>
            <hr />
            <div className="flex justify-between text-xl font-bold text-blue-600">
              <span>Total:</span>
              <span>
                $
                {(
                  (calculatedTotalPrice + taxAmount) *
                  quantity
                ).toLocaleString()}
              </span>
            </div>
          </div>
        </div>

        {/* Actions */}
        <div className="flex justify-center gap-4 flex-wrap mb-4">
          <button
            onClick={() => setCurrentView("details")}
            className="bg-gray-600 hover:bg-gray-700 text-white py-2 px-6 rounded"
          >
            Back
          </button>
          <button
            onClick={() => setCurrentView("configure")}
            className="bg-blue-600 hover:bg-blue-700 text-white py-2 px-6 rounded"
          >
            Modify
          </button>
          <button
            onClick={() => window.print()}
            className="bg-green-600 hover:bg-green-700 text-white py-2 px-6 rounded"
          >
            Print
          </button>
        </div>

        {/* Email Invoice Button */}
        <div className="flex justify-center">
          <button
            onClick={handleEmailInvoice}
            disabled={!invoiceId}
            className={`py-3 px-10 rounded text-white font-semibold ${
              invoiceId
                ? "bg-purple-600 hover:bg-purple-700"
                : "bg-gray-400 cursor-not-allowed"
            }`}
          >
            Email Invoice to Me
          </button>
        </div>

        {/* Optional Invoice Message */}
        {invoiceMessage && (
          <p className="mt-4 text-center text-indigo-700">{invoiceMessage}</p>
        )}
      </div>
    </div>
  );
};

export default InvoiceDetails;
