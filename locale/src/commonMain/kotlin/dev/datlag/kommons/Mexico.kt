package dev.datlag.kommons


data object Mexico : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("MX")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MEX")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(484)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(52)
    override val continent: Continent = Continent.NorthAmerica
}